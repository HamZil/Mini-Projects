package com.example.composebasic.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composebasic.entities.relations.StudentSubjectCrossRef


@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao :SchoolDao

    companion object{
        @Volatile

        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this){
                return  INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext, SchoolDatabase::class.java,"SCHOOL.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}