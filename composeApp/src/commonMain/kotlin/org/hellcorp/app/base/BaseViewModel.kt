package org.hellcorp.app.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() {
    private val _viewState = MutableStateFlow(initialState)
    protected var viewState : State
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }
    
    /**
     * _viewAction is using for handling side effects
     *
     * replay 1 is for limiting action lounching
     *
     * BufferOverflow.DROP_OLDEST parametr for removing old data in case of buffering overflow
     */
    private val _viewAction = MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    protected var viewAction : Action?
        get() = _viewAction.replayCache.last()
        set(value) {
            _viewAction.tryEmit(value)
        } 
    
    fun viewStates(): StateFlow<State> = _viewState.asStateFlow()
    
    fun viewActions(): SharedFlow<Action?> = _viewAction.asSharedFlow()
 
    abstract fun obtainEvent(viewEvent: Event)
    
    fun clearAction() {
        viewAction = null
    }
}