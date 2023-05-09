package com.example.finalprojectailatrieuphu.sql.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finalprojectailatrieuphu.sql.Entity.QuestionEntity;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Insert
    void insert(QuestionEntity... cauHois);

    @Delete
    void delete(QuestionEntity cauHoi);

    @Update
    void update(QuestionEntity cauHoi);

    @Query("SELECT * FROM QuestionEntity")
    List<QuestionEntity> getQuestions();

    @Query("SELECT * FROM QuestionEntity WHERE id = :code")
    List<QuestionEntity> getQuestionByCode(String code);

    @Query("SELECT MAX(id) FROM QuestionEntity")
    int getMaxIdQuestion();
}
