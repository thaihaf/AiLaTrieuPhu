package com.example.finalprojectailatrieuphu.object;

import androidx.room.Room;

import com.example.finalprojectailatrieuphu.GameScreen;
import com.example.finalprojectailatrieuphu.sql.Entity.QuestionEntity;
import com.example.finalprojectailatrieuphu.sql.dao.QuestionDAO;
import com.example.finalprojectailatrieuphu.sql.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FaceData {
    private AppDatabase db;
    QuestionDAO QDAO;
    ArrayList<CauHoi> questionArrayList = new ArrayList<>();

    public FaceData() {
    }

    public FaceData(GameScreen contextScreen) {
        //create dao
        db = Room.databaseBuilder(contextScreen, AppDatabase.class, "question.db")
                .allowMainThreadQueries().build();
        QDAO = db.createQuestionDAO();
        //insert some question into sql
        if (QDAO.getMaxIdQuestion() <= 1) {
            QDAO.insert(createListQuestion());
        }
        //get question from sql
        updateListCauHoi();
    }

    /**
     * convert question entity to question object
     * @param q
     * @return
     */
    public CauHoi ConvertQEntityToCauHoi(QuestionEntity q) {
        CauHoi c = new CauHoi();
        c.setNoiDung(q.getNoiDung());
        c.setDapAnDung(q.getDapAnDung());
        c.setArrDapAnSai(q.getDapAnSai1() + "&" + q.getDapAnSai2() + "&" + q.getDapAnSai3());
        c.setCapdo(q.getCapdo());
        return c;
    }

    /**
     * get all question on database
     */
    public void updateListCauHoi() {
        questionArrayList = new ArrayList<>();
        List<QuestionEntity> questionEntityArrayList = QDAO.getQuestions();
        for (QuestionEntity q : questionEntityArrayList) {
            CauHoi c = ConvertQEntityToCauHoi(q);
            questionArrayList.add(c);
        }
    }

    /**
     * get random question in list
     * @param level
     * @return
     */
    public CauHoi getRandomQuestionWithLevel(int level) {
        Random r = new Random();
        ArrayList<CauHoi> tempList = new ArrayList<>();
        for (CauHoi c : questionArrayList) {
            if (c.getCapdo() == level) {
                tempList.add(c);
            }
        }
        return tempList.get(r.nextInt(tempList.size()));
    }

    /**
     * create a entity question
     * @param noidung
     * @param cAnswer
     * @param wAnswer1
     * @param wAnswer2
     * @param wAnswer3
     * @param levelQuestion
     * @return
     */
    public QuestionEntity createQuestionOfDB(String noidung,
                                             String cAnswer,
                                             String wAnswer1, String wAnswer2, String wAnswer3,
                                             int levelQuestion) {
        QuestionEntity q = new QuestionEntity();
        q.setNoiDung(noidung);
        q.setDapAnDung(cAnswer);
        q.setDapAnSai1(wAnswer1);
        q.setDapAnSai2(wAnswer2);
        q.setDapAnSai3(wAnswer3);
        q.setCapdo(levelQuestion);
        return q;
    }
    public void removeQuestion(CauHoi cauHoi){
        questionArrayList.remove(cauHoi);
    }

    /**
     * hard code create list question
     * @return
     */
    public QuestionEntity[] createListQuestion() {
        List<QuestionEntity> tempList = new ArrayList<>();
        //1
        tempList.add(createQuestionOfDB("Điền từ còn thiếu vào câu ca dao: \"Gần mực thì đen, gần đèn thì...\"gì?",
                "Sáng",
                "Chói", "Lóa", "Tối",
                1));
        //2
        tempList.add(createQuestionOfDB("Mưa ngâu là vào khoảng tháng mấy trong năm?",
                "7",
                "1", "3", "5",
                2));
        //3
        tempList.add(createQuestionOfDB("Cầu thủ nào đạt danh hiệu Quả bóng vàng Việt Nam năm 2010?",
                "Minh Phương",
                "Vũ Phong", "Tấn Trường", "Trọng Hoàng",
                2));
        //4
        tempList.add(createQuestionOfDB("An Dương Vương đặt quốc hiệu nước ta là gì?",
                "Đại Cồ Việt",
                "Âu Lạc", "Vạn Xuân", "Đại Việt",
                3));
        //5
        tempList.add(createQuestionOfDB("Đâu là tên một loại bánh Huế?",
                "Khoái",
                "Sướng", "Thích", "Vui",
                1));
        //6
        tempList.add(createQuestionOfDB("Nhà văn Kim Dung (Trung Quốc) nổi tiếng với thể loại văn học gì?",
                "Tiểu thuyết kiếm hiệp",
                "Truyện trinh thám", "Sử thi", "Thơ lãng mạn",
                2));
        //7
        tempList.add(createQuestionOfDB("Bộ phim \"Chị Dậu\" được chuyển thể từ tác phẩm nào?",
                "Tắt đèn",
                "Người mẹ cầm súng", "Vợ chồng A Phủ", "Tuổi thơ dữ dội",
                2));
        //8
        tempList.add(createQuestionOfDB("Hoa hậu Hòa bình Quốc tế 2017 dự kiến sẽ được tổ chức tại quốc gia nào?",
                "Việt Nam",
                "Thái Lan", "Lào", "Campuchia",
                2));
        //9
        tempList.add(createQuestionOfDB("Tôi đi học của Thanh Tịnh được viết theo thể loại nào?",
                "Truyện ngắn",
                "Bút kí", "Tiểu thuyết", "Tuỳ bút",
                2));
        //10
        tempList.add(createQuestionOfDB("Nhân vật chính trong văn bản\" Tôi đi học” là ai?",
                "Nhân vật “tôi”",
                "Người mẹ", "Người thầy giáo", "Ông đốc",
                2));
        //11
        tempList.add(createQuestionOfDB("1 + 1 = ?",
                "2",
                "3", "4", "5",
                1));
        //12
        tempList.add(createQuestionOfDB("Những ngày thơ ấu của Nguyên Hồng được viết theo thể loại nào?\n",
                "Hồi kí",
                "Bút kí", "Truyện ngắn", "Tiểu thuyết",
                3));
        //13
        tempList.add(createQuestionOfDB("Từ ngữ nào dưới đây không mang nghĩa “thuốc chữa bệnh”?",
                "Thuốc lào",
                "Thuốc kháng sinh", "Thuốc tẩy giun", "Thuốc ho",
                3));
        //14
        tempList.add(createQuestionOfDB("Loại quả nào không ăn được?",
                "Quả còn",
                "Quả xoài", "Quả nhãn", "Quả táo",
                3));
        //15
        tempList.add(createQuestionOfDB("Trong bài hát “Mẹ yêu không nào”, con cò bé bé đậu ở đâu?",
                "Cành tre",
                "Cành hoa", "Cành cọ", "Cành trúc",
                1));
        //16
        tempList.add(createQuestionOfDB("Quốc gia nào dưới đây không thuộc châu Á?",
                "Hà Lan",
                "Lào", "Mông Cổ", "Hàn Quốc",
                1));
        //17
        tempList.add(createQuestionOfDB("hai không bốn tám là số nào sau ?",
                "2048",
                "008888", "28", "208888",
                4));
        //18
        tempList.add(createQuestionOfDB("Mỗi năm có 7 tháng 31 ngày. Đố bạn có bao nhiêu tháng có 28 ngày",
                "12",
                "1", "8", "5",
                1));
        //19
        tempList.add(createQuestionOfDB("Theo Văn phòng Tham khảo Dân số, thì tổng số người từng sống trên Trái Đất từ xưa đến nay là khoảng bao nhiêu người?",
                "100 tỷ",
                "50 tỷ", "5.000 tỷ", "1.000 tỷ",
                1));
        //20
        tempList.add(createQuestionOfDB("Các nhà thần kinh học tin rằng vỏ thùy giữa trán của não được kích hoạt khi bạn làm gì?",
                "Hiểu một chuyện cười",
                "Bị hoảng loạn", "Ghi nhớ một cái tên", "Nghe nhạc",
                2));
        //21
        tempList.add(createQuestionOfDB("Trái Đất cách Mặt Trời khoảng bao nhiêu dặm?",
                "93 triệu",
                "9,3 triệu", "39 triệu", "193 triệu",
                2));
        //22
        tempList.add(createQuestionOfDB("Loài côn trùng nào đã từng làm chập một chiếc máy tính và sau đó khiến người ta bắt đầu dùng cụm từ computer bug (“rệp máy tính”, tức là lỗi phần mềm)?",
                "Sâu bướm",
                "Bọ cánh cứng Nhật Bản", "Gián", "Ruồi",
                3));
        //23
        tempList.add(createQuestionOfDB("Tổng thống Mỹ nào từng xuất hiện trong loạt phim truyền hình Laugh-In?",
                "Richard Nixon",
                " Lyndon Johnson.", "Jimmy Carter", "Gerald Ford",
                4));
        //24
        tempList.add(createQuestionOfDB("Theo  1 câu hát thì \"Ba thương con vì con giống mẹ, mẹ thương con vì con giống ...\" ai ?",
                "Ba",
                "Chú đầu ngõ", "Bác cạnh nhà", "Ông hàng xóm",
                1));
        //25
        tempList.add(createQuestionOfDB("せきにんかんがある có nghĩa là gì",
                "Có tinh thần trách nhiệm",
                "Nhút nhát", "Hoạt bát", "Hiền lành",
                3));
        QuestionEntity[] temparr = new QuestionEntity[tempList.size()];
        tempList.toArray(temparr);
        return temparr;
    }
}
