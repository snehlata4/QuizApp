package com.quizgame.squareandcubesquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Squaresandcubes.db";
    private static final int DATABASE_VERSION=1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionTable.TABLE_NAME + " ( " +
                QuizContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionTable.COLUMN_QUESTION+ " TEXT, " +
                QuizContract.QuestionTable.COLUMN_ANSWER + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
     fillquestiontable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionTable.TABLE_NAME);
     onCreate(db);
    }

    private void fillquestiontable()
    {
     question q1=new question("15²","225","Easy");
     addquestion(q1);
        question q2=new question("18²","324","Easy");
        addquestion(q2);
        question q3=new question("19²","361","Easy");
        addquestion(q3);
        question q4=new question("30²","900","Easy");
        addquestion(q4);
        question q5=new question("41²","1681","Easy");
        addquestion(q5);
        question q6=new question("25²","625","Easy");
        addquestion(q6);
        question q7=new question("35²","1225","Easy");
        addquestion(q7);


       question q10=new question("5³","125","Easy");
        addquestion(q10);
        question q11=new question("2⁵","32","Easy");
        addquestion(q11);
       question q12=new question("3³","27","Easy");
        addquestion(q12);
        question q13=new question("50²","2500","Easy");
       addquestion(q13);
        question q14=new question("1.5²","2.25","Easy");
        addquestion(q14);
        question q15=new question("100³","1000000","Easy");
        addquestion(q15);
        question q16=new question("17²","289","Easy");
        addquestion(q16);
        question q17=new question("16²","256","Easy");
       addquestion(q17);
        question q18=new question("14²","196","Easy");
        addquestion(q18);

        question q19=new question("4³","64","Easy");
       addquestion(q19);
        question q20=new question("4⁴","256","Easy");
        addquestion(q20);
        question q21=new question("21²","441","Easy");
        addquestion(q21);
        question q22=new question("1875+567","2442","Easy");
        addquestion(q22);
       question q23=new question("999+111","1110","Easy");
        addquestion(q23);
       question q24=new question("11²","121","Easy");
       addquestion(q24);
        question q25=new question("1530/5","306","Easy");
        addquestion(q25);

        question q26=new question("3/2","1.5","Easy");
        addquestion(q26);
       question q27=new question("8/5","1.6","Easy");
        addquestion(q27);
        question q28=new question("10/4","2.5","Easy");
        addquestion(q28);
        question q29=new question("11/4","2.75","Easy");
        addquestion(q29);
       question q30=new question("9/4","2.25","Easy");
       addquestion(q30);
        question q31=new question("99/3","33","Easy");
        addquestion(q31);
       question q32=new question("88/10","8.8","Easy");
        addquestion(q32);
        question q33=new question("70²","4900","Easy");
        addquestion(q33);

        question q34=new question("1222-879","1554","Easy");
        addquestion(q34);
        question q35=new question("567+987","1554","Easy");
        addquestion(q35);
        question q36=new question("90²","8100","Easy");
        addquestion(q36);
        question q37=new question("11³","1331","Easy");
        addquestion(q37);
        question q38=new question("343/7","49","Easy");
        addquestion(q38);
        question q39=new question("123+456","579","Easy");
        addquestion(q39);
        question q40=new question("789+012","801","Easy");
        addquestion(q40);
        question q41=new question("45*5","225","Easy");
        addquestion(q41);
        question q42=new question("234+98","332","Easy");
        addquestion(q42);
        question q43=new question("555+666","1221","Easy");
        addquestion(q43);
        question q44=new question("32+34","66","Easy");
        addquestion(q44);

        question q45=new question("1221-1008","213","Easy");
        addquestion(q45);

        question q46=new question("30³","27000","Easy");
       addquestion(q46);

        question q47=new question("20⁴","160000","Easy");
        addquestion(q47);
       question q48=new question("785-699","86","Easy");
        addquestion(q48);

       question q49=new question("87-67","20","Easy");
        addquestion(q49);

        question q50=new question("1521-1222","299","Easy");
        addquestion(q50);

        question q51=new question("67*2","134","Easy");
        addquestion(q51);

        question q52=new question("129*2","258","Easy");
        addquestion(q52);

        question q53=new question("222*3","666","Easy");
      addquestion(q53);

        question q54=new question("333*4","1332","Easy");
       addquestion(q54);

      question q55=new question("22*5","110","Easy");
        addquestion(q55);

        question q56=new question("80/4","20","Easy");
        addquestion(q56);

       question q57=new question("3³","81","Easy");
       addquestion(q57);
       question q58=new question("41/4","10.25","Easy");
        addquestion(q58);
        question q59=new question("111/2","505.5","Easy");
        addquestion(q59);
       question q60=new question("132/3","44","Easy");
       addquestion(q60);
        question q61=new question("19-11","8","Easy");
       addquestion(q61);
      question q62=new question("12+1198","1210","Easy");
        addquestion(q62);
        question q63=new question("45+55","100","Easy");
        addquestion(q63);
       question q64=new question("34+99","133","Easy");
       addquestion(q64);
     question q65=new question("1222+34","1256","Easy");
        addquestion(q65);
        question q66=new question("51²","2601","Easy");
       addquestion(q66);
        question q67=new question("7³","343","Easy");
        addquestion(q67);

        question q68=new question("36/5","7.2","Easy");
      addquestion(q68);
       question q69=new question("10*0.2","2","Easy");
        addquestion(q69);
        question q70=new question("0.2*18","3.6","Easy");
        addquestion(q70);
        question q71=new question("0.5*8","4","Easy");
       addquestion(q71);
        question q72=new question("55/11","5","Easy");
        addquestion(q72);
       question q73=new question("84/12","7","Easy");
        addquestion(q73);
        question q74=new question("8*6","48","Easy");
        addquestion(q74);
        question q75=new question("9*7","63","Easy");
        addquestion(q75);
        question q76=new question("8*9","72","Easy");
        addquestion(q76);
        question q77=new question("10*67","670","Easy");
        addquestion(q77);
       question q78=new question("89/10","8.9","Easy");
       addquestion(q78);

       question q79=new question("51/5","10.2","Easy");
        addquestion(q79);

       question q80=new question("90/18","5","Easy");
        addquestion(q80);
       question q81=new question("65/5","13","Easy");
        addquestion(q81);
      question q82=new question("30*8","240","Easy");
        addquestion(q82);
        question q83=new question("1552/2","776","Easy");
        addquestion(q83);
        question q84=new question("656/2","328","Easy");
        addquestion(q84);

//
        question q85=new question("18²","324","Medium");
     addquestion(q85);

       question q86=new question("51²","2601","Medium");
        addquestion(q86);

        question q87=new question("12²","144","Medium");
        addquestion(q87);

     question q88=new question("71²","5041","Medium");
        addquestion(q88);
        question q89=new question("80²","6400","Medium");
     addquestion(q89);
        question q90=new question("6³","216","Medium");
        addquestion(q90);
        question q91=new question("120²","14400","Medium");
        addquestion(q91);
        question q92=new question("6.2*2","12.4","Medium");
       addquestion(q92);
        question q93=new question("3.3*3","9.9","Medium");
        addquestion(q93);
        question q94=new question("10.2*3","30.6","Medium");
        addquestion(q94);
        question q95=new question("2+6*3","20","Medium");
        addquestion(q95);
        question q96=new question("50-6*3","32","Medium");
       addquestion(q96);
        question q97=new question("12/3-1","3","Medium");
        addquestion(q97);
        question q98=new question("77/7-10","1","Medium");
       addquestion(q98);

        question q99=new question("39/13-2","1","Medium");
        addquestion(q99);
        question q100=new question("2+4+6*2","18","Medium");
        addquestion(q100);
     question q101=new question("6*4/2-4","8","Medium");
        addquestion(q101);
        question q102=new question("5*5-4","21","Medium");
        addquestion(q102);
        question q103=new question("34*2-56","12","Medium");
        addquestion(q103);
        question q104=new question("45*4","180","Medium");
        addquestion(q104);
        question q105=new question("50-6*8","2","Medium");
       addquestion(q105);
       question q106=new question("6*6/3","12","Medium");
        addquestion(q106);
        question q107=new question("9*0.3","2.7","Medium");
        addquestion(q107);
        question q108=new question("4.5/1.5","3","Medium");
        addquestion(q108);
        question q109=new question("48-42/6","40","Medium");
        addquestion(q109);
        question q110=new question("8*12-88","8","Medium");
        addquestion(q110);
        question q111=new question("67-29","38","Medium");
        addquestion(q111);
        question q112=new question("78*2","156","Medium");
        addquestion(q112);
        question q113=new question("12*4","168","Medium");
        addquestion(q113);
        question q114=new question("56/2-22","6","Medium");
        addquestion(q114);
        question q115=new question("8*2*2/4","8","Medium");
        addquestion(q115);
        question q116=new question("6*6/12","3","Medium");
        addquestion(q116);

        question q117=new question("23*4/11.5","8","Medium");
        addquestion(q117);

        question q118=new question("8-(4*2-3*2)","6","Medium");
        addquestion(q118);

        question q119=new question("5*3-8","7","Medium");
        addquestion(q119);

       question q120=new question("34*6/17","12","Medium");
        addquestion(q120);

        question q121=new question("39/2","19.5","Medium");
        addquestion(q121);

        question q122=new question("21-6+12-18","9","Medium");
        addquestion(q122);

        question q123=new question("66*2","132","Medium");
        addquestion(q123);

        question q124=new question("8*5-12*3","4","Medium");
        addquestion(q124);

        question q125=new question("55*4","220","Medium");
        addquestion(q125);

        question q126=new question("98*4","392","Medium");
        addquestion(q126);

        question q127=new question("45-60/15","41","Medium");
        addquestion(q127);

        question q128=new question("66-5*11","11","Medium");
        addquestion(q128);

        question q129=new question("108-44*2","20","Medium");
        addquestion(q129);

        question q130=new question("33/11","3","Medium");
        addquestion(q130);

        question q131=new question("80/16-3","2","Medium");
        addquestion(q131);

        question q132=new question("(12²)-(11²)","23","Medium");
        addquestion(q132);

        question q133=new question("34*0.5","17","Medium");
        addquestion(q133);

        question q134=new question("22/5.5","4","Medium");
        addquestion(q134);

        question q135=new question("4/5","0.8","Medium");
        addquestion(q135);

        question q136=new question("11/5","2.2","Medium");
        addquestion(q136);

        question q137=new question("153/9","17","Medium");
        addquestion(q137);
        question q138=new question("6*7*2","84","Medium");
        addquestion(q138);
        question q139=new question("2*3*3*1*2","36","Medium");
        addquestion(q139);
        question q140=new question("2⁵","32","Medium");
        addquestion(q140);
        question q141=new question("32-78+86","40","Medium");
        addquestion(q141);
        question q142=new question("55-44+33-22+11","33","Medium");
        addquestion(q142);
        question q143=new question("11-11*0.5","5.5","Medium");
        addquestion(q143);
        question q144=new question("12*17","204","Medium");
        addquestion(q144);
        question q145=new question("19*20","380","Medium");
        addquestion(q145);
        question q146=new question("45-23+56-46","32","Medium");
        addquestion(q146);
        question q147=new question("5*4/2*3","30","Medium");
        addquestion(q147);
        question q148=new question("8*8*8/64","8","Medium");
        addquestion(q148);
        question q149=new question("2+3+4+5+66","80","Medium");
        addquestion(q149);
        question q150=new question("7+8+9+10","36","Medium");
        addquestion(q150);
        question q151=new question("11³","1331","Medium");
        addquestion(q151);

        question q152=new question("46.5/2","23.25","Medium");
        addquestion(q152);
        question q153=new question("1.25*4³","5","Medium");
        addquestion(q153);
        question q154=new question("252/3","84","Medium");
        addquestion(q154);
        question q155=new question("22/4","5.5","Medium");
        addquestion(q155);
        question q156=new question("65/13+13","18","Medium");
        addquestion(q156);
        question q157=new question("33/66+1","1.5","Medium");
        addquestion(q157);
        question q158=new question("7+8+9-15","9","Medium");
        addquestion(q158);
        question q159=new question("54-66/3","32","Medium");
        addquestion(q159);
        question q160=new question("87-55+49","81","Medium");
        addquestion(q160);
        question q161=new question("76+7*6-3","115","Medium");
        addquestion(q161);
        question q162=new question("90/18-8+21","18","Medium");
        addquestion(q162);


        question q163=new question("1331/11","121","Hard");
        addquestion(q163);
        question q164=new question("12*11","168","Hard");
        addquestion(q164);
        question q165=new question("9*19","171","Hard");
        addquestion(q165);
        question q166=new question("78-8²","14","Hard");
        addquestion(q166);

        question q167=new question("1555-11³","224","Hard");
        addquestion(q167);





        question q184=new question("12.5/2.5","5","Hard");
        addquestion(q184);

        question q185=new question("14/5","2.4","Hard");
        addquestion(q185);

        question q186=new question("123/12.3","10","Hard");
        addquestion(q186);

        question q187=new question("1.1*40","44","Hard");
        addquestion(q187);

        question q188=new question("9.2+4.8","14","Hard");
        addquestion(q188);

        question q189=new question("7.9+6.1+7.3","21.3","Hard");
        addquestion(q189);

        question q190=new question("88*9","792","Hard");
        addquestion(q190);

        question q191=new question("4+5*2-4","10","Hard");
        addquestion(q191);

        question q192=new question("12*4-22*2","4","Hard");
        addquestion(q192);

        question q193=new question("5*5+5/5","26","Hard");
        addquestion(q193);

        question q194=new question("54*12","648","Hard");
        addquestion(q194);

        question q195=new question("1212/3-300","104","Hard");
        addquestion(q195);

        question q196=new question("561/3","187","Hard");
        addquestion(q196);


        question q197=new question("12+32+12/4","47","Hard");
        addquestion(q197);


        question q198=new question("12*13","156","Hard");
        addquestion(q198);


        question q199=new question("45*4-30","150","Hard");
        addquestion(q199);


        question q200=new question("55²","3025","Hard");
        addquestion(q200);


        question q201=new question("9³","729","Hard");
        addquestion(q201);


        question q202=new question("41²","1681","Hard");
        addquestion(q202);




    }
    private void addquestion(question question)
    {
        ContentValues cv=new ContentValues();
        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuizContract.QuestionTable.COLUMN_ANSWER,question.getAnswer());
        cv.put(QuizContract.QuestionTable.COLUMN_DIFFICULTY,question.getDifficulty());

        db.insert(QuizContract.QuestionTable.TABLE_NAME,null,cv);

    }
    public List<question> getallquestions()
    {
        List<question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        String[] selectionArgs = new String[]{};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME, null);
       if(c.moveToFirst()){
           do{
               question question=new question();
               question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
               question.setAnswer(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER)));
               question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_DIFFICULTY)));


               questionList.add(question);
           }
           while (c.moveToNext());



       }
c.close();
       return questionList;
    }
    public List<question> getquestions(String difficulty)
    {
        List<question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        String[] selectionArgs=new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionTable.COLUMN_DIFFICULTY + "=?", selectionArgs);
        if(c.moveToFirst()){
            do{
                question question=new question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setAnswer(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_DIFFICULTY)));




                questionList.add(question);
            }
            while (c.moveToNext());



        }
        c.close();
        return questionList;
    }
}
