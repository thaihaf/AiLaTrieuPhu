package com.example.finalprojectailatrieuphu.sql.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalprojectailatrieuphu.sql.Entity.QuestionEntity;
import com.example.finalprojectailatrieuphu.sql.dao.QuestionDAO;


@Database(entities = {QuestionEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuestionDAO createQuestionDAO();
}
