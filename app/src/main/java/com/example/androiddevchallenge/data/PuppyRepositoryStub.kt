/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.models.PuppyInfo

class PuppyRepositoryStub : PuppyRepository {

    private val list by lazy {
        listOf(
            PuppyInfo(1, R.drawable.puppy1, "Apollo", desc, 5f, 30f, "Dark"),
            PuppyInfo(2, R.drawable.puppy2, "Duke", desc, 5f, 30f, "Light"),
            PuppyInfo(3, R.drawable.puppy3, "Loki", desc, 5f, 30f, "Light"),
            PuppyInfo(4, R.drawable.puppy4, "Sam", desc, 5f, 30f, "Light"),
        )
    }

    private val errorItem by lazy {
        PuppyInfo(-1, R.drawable.error, "Error", "Error", 0f, 0f, "Error")
    }

    override fun getPuppyList(): List<PuppyInfo> {
        return list
    }

    override fun getPuppy(id: Long): PuppyInfo {
        return list.find { puppyInfo ->
            puppyInfo.id == id
        } ?: errorItem
    }

    private val desc =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean aliquet pharetra enim id tincidunt. Vivamus at pellentesque lorem, eu gravida tortor. Aliquam sed mattis neque, sit amet dignissim nunc. Maecenas tempus sem ultrices suscipit tincidunt. Nam interdum interdum purus id varius. Mauris vitae sem eget nibh molestie rhoncus. Aliquam rhoncus dolor ut felis tincidunt condimentum. In placerat dolor ligula, nec dictum velit vulputate vel. Quisque posuere nunc ut imperdiet gravida. Proin convallis congue scelerisque. Curabitur sit amet augue dictum, sollicitudin quam ut, consequat purus. Cras posuere pulvinar purus non malesuada."
}
