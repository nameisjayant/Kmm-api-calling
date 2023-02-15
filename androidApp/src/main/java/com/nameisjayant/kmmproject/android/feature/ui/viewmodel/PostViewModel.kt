package com.nameisjayant.kmmproject.android.feature.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameisjayant.kmmproject.common.doOnFailure
import com.nameisjayant.kmmproject.common.doOnLoading
import com.nameisjayant.kmmproject.common.doOnSuccess
import com.nameisjayant.kmmproject.data.model.Post
import com.nameisjayant.kmmproject.data.repository.PostRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postResponse: MutableState<PostState> = mutableStateOf(PostState())
    val postResponse: State<PostState> = _postResponse

    init {
        viewModelScope.launch {
            repository.getPosts()
                .doOnSuccess {
                    _postResponse.value = PostState(
                        data = it
                    )
                }
                .doOnFailure {
                    _postResponse.value = PostState(
                        error = it?.message ?: "Something went wrong!"
                    )
                }
                .doOnLoading {
                    _postResponse.value = PostState(
                        isLoading = true
                    )
                }
                .collect()
        }
    }

}

data class PostState(
    val data: List<Post> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)