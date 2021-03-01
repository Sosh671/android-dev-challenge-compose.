package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.models.PuppyInfo

class PuppyRepositoryStub : PuppyRepository {

    private val list by lazy {
        listOf(
            PuppyInfo(1, R.drawable.puppy1, "Apollo", desc, 5f, 30f, "Dark"),
            PuppyInfo(2, R.drawable.puppy2, "Duke", desc,5f, 30f, "Light"),
            PuppyInfo(3, R.drawable.puppy3, "Loki", desc,5f, 30f, "Light"),
            PuppyInfo(4, R.drawable.puppy4, "Sam", desc,5f, 30f, "Light"),
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