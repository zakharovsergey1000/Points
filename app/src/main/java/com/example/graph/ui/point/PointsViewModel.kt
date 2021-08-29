package com.example.graph.ui.point

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.graph.repository.PointsRepository
import com.example.graph.util.AbsentLiveData
import com.example.graph.vo.Point
import com.github.mikephil.charting.data.LineDataSet
import javax.inject.Inject

//@OpenForTesting
class PointsViewModel @Inject constructor(repository: PointsRepository) : ViewModel() {
    lateinit var dataSet: LineDataSet
    var listResource: List<Point>? = null
    private val _repoId: MutableLiveData<String> = MutableLiveData()
    val repoId: LiveData<String>
        get() = _repoId

    val points: LiveData<List<Point>> =_repoId.switchMap { input ->
        repository.loadPoints(input)
    }

    fun setId(owner: String) {
        if (_repoId.value != owner) {
            _repoId.value = owner
        }
    }

    data class RepoId(val owner: String, val name: String) {
        fun <T> ifExists(f: (String, String) -> LiveData<T>): LiveData<T> {
            return if (owner.isBlank() || name.isBlank()) {
                AbsentLiveData.create()
            } else {
                f(owner, name)
            }
        }
    }
}
