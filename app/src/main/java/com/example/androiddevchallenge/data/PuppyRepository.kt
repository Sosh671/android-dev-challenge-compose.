package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.PuppyInfo

interface PuppyRepository {

    fun getPuppyList(): List<PuppyInfo>
    fun getPuppy(id: Long): PuppyInfo
}