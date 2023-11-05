package ru.samsung.academy.m20i.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_table")
data class Count(
    @PrimaryKey var id : Long,
    var number : Long)