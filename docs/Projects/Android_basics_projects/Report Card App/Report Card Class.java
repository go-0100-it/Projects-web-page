
package com.example.android.music_player_project5.reportcard;

/**
 * Created by WatersD on 7/13/2016.
 */
import android.content.Context;

/**
 * Created by WatersD on 7/13/2016.
 */
public class ReportCard{

    private static final int A_GRADE = 80;
    private static final int B_GRADE = 70;
    private static final int C_GRADE = 60;
    private static final int D_GRADE = 50;

    //Students name
    private String mStudent;

    //Subject student was graded on
    private String mSubject1,mSubject2,mSubject3,mSubject4,mSubject5,mSubject6,mSubject7,mSubject8;

    //Teacher of this subject
    private String mTeacher1,mTeacher2,mTeacher3,mTeacher4,mTeacher5,mTeacher6,mTeacher7,mTeacher8;

    //Grade student achieved at mid term (1-100)
    private int mMidTermGrade1,mMidTermGrade2,mMidTermGrade3,mMidTermGrade4,mMidTermGrade5,
				mMidTermGrade6,mMidTermGrade7,mMidTermGrade8;

    //Final grade student achieved (1-100)
    private int mFinalGrade1,mFinalGrade2,mFinalGrade3,mFinalGrade4,mFinalGrade5,mFinalGrade6,
				mFinalGrade7,mFinalGrade8;

    //Teachers comments at mid term
    private String mMidTermComments1,mMidTermComments2,mMidTermComments3,mMidTermComments4,
				   mMidTermComments5,mMidTermComments6,mMidTermComments7,mMidTermComments8;

    //Teachers final comments
    private String mFinalComments1,mFinalComments2,mFinalComments3,mFinalComments4,mFinalComments5,
				   mFinalComments6,mFinalComments7,mFinalComments8;

    //Context of the app
    private Context mContext;

    /**
     * Constructs a new com.example.android.reportcard.ReportCard Object with initial values for all variables
     */
    public ReportCard(Context context){
        mStudent = "";

        mSubject1 = ""; mSubject2 = ""; mSubject3 = ""; mSubject4 = ""; mSubject5 = ""; 
		mSubject6 = ""; mSubject7 = ""; mSubject8 = "";

        mTeacher1 = ""; mTeacher2 = ""; mTeacher3 = ""; mTeacher4 = ""; mTeacher5 = ""; 
		mTeacher6 = ""; mTeacher7 = ""; mTeacher8 = "";

        mMidTermGrade1 = 0; mMidTermGrade2 = 0; mMidTermGrade3 = 0; mMidTermGrade4 = 0; 
		mMidTermGrade5 = 0; mMidTermGrade6 = 0; mMidTermGrade7 = 0;
        mMidTermGrade8 = 0;

        mFinalGrade1 = 0; mFinalGrade2 = 0; mFinalGrade3 = 0; mFinalGrade4 = 0; mFinalGrade5 = 0; 
		mFinalGrade6 = 0; mFinalGrade7 = 0; mFinalGrade8 = 0;

        mMidTermComments1 = ""; mMidTermComments2 = ""; mMidTermComments3 = ""; mMidTermComments4 = ""; 
		mMidTermComments5 = ""; mMidTermComments6 = ""; mMidTermComments7 = ""; mMidTermComments8 = "";

        mFinalComments1 = ""; mFinalComments2 = ""; mFinalComments3 = ""; mFinalComments4 = ""; 
		mFinalComments5 = ""; mFinalComments6 = ""; mFinalComments7 = ""; mFinalComments8 = "";

        mContext = context;
    }

    /**
     * Sets the name of the student
     *
     * @param student is the student this report card is for
     */
    public void setStudent(String student){
        mStudent = student;
    }

    /**
     * Sets the name of the mTeacher for mSubject (For up to 8 subjects)
     *
     * @param teacher is the inputted name of the teacher of mSubject
     * @param subjectNumber is the int value which determines the corresponding subject by index.
     */
    public void setTeacher(String teacher,int subjectNumber){
        switch(subjectNumber){
            case 1:
                mTeacher1 = teacher;
                break;
            case 2:
                mTeacher2 = teacher;
                break;
            case 3:
                mTeacher3 = teacher;
                break;
            case 4:
                mTeacher4 = teacher;
                break;
            case 5:
                mTeacher5 = teacher;
                break;
            case 6:
                mTeacher6 = teacher;
                break;
            case 7:
                mTeacher7 = teacher;
                break;
            case 8:
                mTeacher8 = teacher;
                break;
            default:
                break;
        }
    }

    /**
     * Sets the name of the mSubject for mStudent (8 possible subjects)
     *
     * @param subject is the inputted name of the mSubject
     * @param subjectNumber is the int value which determines the subject index.
     */
    public void setSubject(String subject,int subjectNumber) {
        mSubject1 = subject;
        switch (subjectNumber) {
            case 1:
                mSubject1 = subject;
                break;
            case 2:
                mSubject2 = subject;
                break;
            case 3:
                mSubject3 = subject;
                break;
            case 4:
                mSubject4 = subject;
                break;
            case 5:
                mSubject5 = subject;
                break;
            case 6:
                mSubject6 = subject;
                break;
            case 7:
                mSubject7 = subject;
                break;
            case 8:
                mSubject8 = subject;
                break;
            default:
                break;
        }
    }

    /**
     * Sets the mMidTermGrade for mSubject(a value between 0 and 100) (For up to 8 subjects)
     *
     * @param grade is the inputted midTerm grade value out of 100. Value can be (1-100)
     * @param subjectNumber is the int value which determines the corresponding subject by index.
     */
    public void setMidTermGrade(int grade,int subjectNumber){
        switch(subjectNumber){
            case 1:
                mMidTermGrade1 = grade;
                break;
            case 2:
                mMidTermGrade2 = grade;
                break;
            case 3:
                mMidTermGrade3 = grade;
                break;
            case 4:
                mMidTermGrade4 = grade;
                break;
            case 5:
                mMidTermGrade5 = grade;
                break;
            case 6:
                mMidTermGrade6 = grade;
                break;
            case 7:
                mMidTermGrade7 = grade;
                break;
            case 8:
                mMidTermGrade8 = grade;
                break;
            default:
                break;
        }
    }

    /**
     * * Sets the mFinalGrade for mSubject(a value between 0 and 100) (For up to 8 subjects)
     *
     * @param grade is the inputted final grade out of 100. Value can be (1-100)
     * @param subjectNumber is the int value which determines subject by index.
     */
    public void setFinalGrade(int grade,int subjectNumber){
        switch(subjectNumber){
            case 1:
                mFinalGrade1 = grade;
                break;
            case 2:
                mFinalGrade2 = grade;
                break;
            case 3:
                mFinalGrade3 = grade;
                break;
            case 4:
                mFinalGrade4 = grade;
                break;
            case 5:
                mFinalGrade5 = grade;
                break;
            case 6:
                mFinalGrade6 = grade;
                break;
            case 7:
                mFinalGrade7 = grade;
                break;
            case 8:
                mFinalGrade8 = grade;
                break;
            default:
                break;
        }
    }

    /**
     *  Sets the mMidTermComments for mSubject (mTeachers comments about students achievements and 
	 *	improvements at mid-term) (For up to 8 subjects)
     *
     * @param comments - are the inputted teachers comments about students achievements and 
	 *	improvements at mid-term.
	 *	
     * @param subjectNumber is the int value which determines the corresponding subject by index.
     */
    public void setMidTermComments(String comments,int subjectNumber){
        switch(subjectNumber){
            case 1:
                mMidTermComments1 = comments;
                break;
            case 2:
                mMidTermComments2 = comments;
                break;
            case 3:
                mMidTermComments3 = comments;
                break;
            case 4:
                mMidTermComments4 = comments;
                break;
            case 5:
                mMidTermComments5 = comments;
                break;
            case 6:
                mMidTermComments6 = comments;
                break;
            case 7:
                mMidTermComments7 = comments;
                break;
            case 8:
                mMidTermComments8 = comments;
                break;
            default:
                break;
        }
    }

    /**
     * Sets the mFinalComments for mSubject(mTeachers comments about students achievements 
	 * and performance at end of year). (For up to 8 subjects)
     *
     * @param comments - are the inputted teachers comments about students achievements 
	 *	and performance at end of year.
	 *	
     * @param subjectNumber is the int value which determines the corresponding subject by index.
     */
    public void setFinalComments(String comments,int subjectNumber){
        switch(subjectNumber){
            case 1:
                mFinalComments1 = comments;
                break;
            case 2:
                mFinalComments2 = comments;
                break;
            case 3:
                mFinalComments3 = comments;
                break;
            case 4:
                mFinalComments4 = comments;
                break;
            case 5:
                mFinalComments5 = comments;
                break;
            case 6:
                mFinalComments6 = comments;
                break;
            case 7:
                mFinalComments7 = comments;
                break;
            case 8:
                mFinalComments8 = comments;
                break;
            default:
                break;
        }
    }

    /**
     *
     * @return returns the students name for this report object as string.
     */
    public String getStudent(){

        return this.mStudent;
    }

    /**
     * Gets the mSubject corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the subject name to get by index.
     * @return returns subject name as string.
     */
    public String getSubject(int subjectNumber){
        String subject = "";
        switch (subjectNumber){
            case 1:
                subject = mSubject1;
                break;
            case 2:
                subject = mSubject2;
                break;
            case 3:
                subject = mSubject3;
                break;
            case 4:
                subject = mSubject4;
                break;
            case 5:
                subject = mSubject5;
                break;
            case 6:
                subject = mSubject6;
                break;
            case 7:
                subject = mSubject7;
                break;
            case 8:
                subject = mSubject8;
                break;
            default:
                break;
        }
        return subject;
    }

    /**
     * Gets the mTeacher corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mTeacher to get by index.
     * @return returns teachers name as string.
     */
    public String getTeacher(int subjectNumber){
        String teacher = "";
        switch (subjectNumber){
            case 1:
                teacher = mTeacher1;
                break;
            case 2:
                teacher = mTeacher2;
                break;
            case 3:
                teacher = mTeacher3;
                break;
            case 4:
                teacher = mTeacher4;
                break;
            case 5:
                teacher = mTeacher5;
                break;
            case 6:
                teacher = mTeacher6;
                break;
            case 7:
                teacher = mTeacher6;
                break;
            case 8:
                teacher = mTeacher8;
                break;
            default:
                break;
        }
        return teacher;
    }

    /**
     * Gets the mMidTermGrade corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mMidTermGrade to get by index.
     * @return returns grade as integer. value range(0-100)
     */
    public int getMidTermGrade(int subjectNumber){
        int grade = 0;
        switch (subjectNumber){
            case 1:
                grade = mMidTermGrade1;
                break;
            case 2:
                grade = mMidTermGrade2;
                break;
            case 3:
                grade = mMidTermGrade3;
                break;
            case 4:
                grade = mMidTermGrade4;
                break;
            case 5:
                grade = mMidTermGrade5;
                break;
            case 6:
                grade = mMidTermGrade6;
                break;
            case 7:
                grade = mMidTermGrade7;
                break;
            case 8:
                grade = mMidTermGrade8;
                break;
            default:
                break;
        }
        return grade;
    }

    /**
     * Gets the mFinalGrade corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mFinalGrade to get by index.
     * @return returns grade as integer. value range(0-100)
     */
    public int getFinalGrade(int subjectNumber){
        int grade = 0;
        switch (subjectNumber){
            case 1:
                grade = mFinalGrade1;
                break;
            case 2:
                grade = mFinalGrade2;
                break;
            case 3:
                grade = mFinalGrade3;
                break;
            case 4:
                grade = mFinalGrade4;
                break;
            case 5:
                grade = mFinalGrade5;
                break;
            case 6:
                grade = mFinalGrade6;
                break;
            case 7:
                grade = mFinalGrade7;
                break;
            case 8:
                grade = mFinalGrade8;
                break;
            default:
                break;
        }
        return grade;
    }

    /**
     * Gets the mMidTermComments corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mMidTermComments to get by index.
     * @return returns comments as String.
     */
    public String getMidTermComments(int subjectNumber){
        String comments = "";
        switch (subjectNumber){
            case 1:
                comments = mMidTermComments1;
                break;
            case 2:
                comments = mMidTermComments2;
                break;
            case 3:
                comments = mMidTermComments3;
                break;
            case 4:
                comments = mMidTermComments4;
                break;
            case 5:
                comments = mMidTermComments5;
                break;
            case 6:
                comments = mMidTermComments6;
                break;
            case 7:
                comments = mMidTermComments7;
                break;
            case 8:
                comments = mMidTermComments8;
                break;
            default:
                break;
        }
        return comments;
    }

    /**
     * Gets the mFinalComments corresponding to the index number inputted. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mFinalComments to get by index.
     * @return returns comments as String.
     */
    public String getFinalComments(int subjectNumber){
        String comments = "";
        switch (subjectNumber){
            case 1:
                comments = mFinalComments1;
                break;
            case 2:
                comments = mFinalComments2;
                break;
            case 3:
                comments = mFinalComments3;
                break;
            case 4:
                comments = mFinalComments4;
                break;
            case 5:
                comments = mFinalComments5;
                break;
            case 6:
                comments = mFinalComments6;
                break;
            case 7:
                comments = mFinalComments7;
                break;
            case 8:
                comments = mFinalComments8;
                break;
            default:
                break;
        }
        return comments;
    }

    /**
     * Gets the mMidTermGrade corresponding to the index number inputted and 
	 * computes equivalent letter grade. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mMidTermGrade to get by index.
     * @return returns letter as String.
     */
    public String getMidTermLetterGrade(int subjectNumber){
        String letter = "";
        switch (subjectNumber){
            case 1:
                letter = computeLetterGrade(mMidTermGrade1);
                break;
            case 2:
                letter = computeLetterGrade(mMidTermGrade2);
                break;
            case 3:
                letter = computeLetterGrade(mMidTermGrade3);
                break;
            case 4:
                letter = computeLetterGrade(mMidTermGrade4);
                break;
            case 5:
                letter = computeLetterGrade(mMidTermGrade5);
                break;
            case 6:
                letter = computeLetterGrade(mMidTermGrade6);
                break;
            case 7:
                letter = computeLetterGrade(mMidTermGrade7);
                break;
            case 8:
                letter = computeLetterGrade(mMidTermGrade8);
                break;
            default:
                break;
        }
        return letter;
    }

    /**
     * Gets the mFinalGrade corresponding to the index number inputted and 
	 * computes equivalent letter grade. (Up to 8 possible subjects)
     *
     * @param subjectNumber is the int value which determines the mFinalGrade to get by index.
     * @return returns letter as String.
     */
    public String getFinalLetterGrade(int subjectNumber){
        String letter = "";
        switch (subjectNumber){
            case 1:
                letter = computeLetterGrade(mFinalGrade1);
                break;
            case 2:
                letter = computeLetterGrade(mFinalGrade2);
                break;
            case 3:
                letter = computeLetterGrade(mFinalGrade3);
                break;
            case 4:
                letter = computeLetterGrade(mFinalGrade4);
                break;
            case 5:
                letter = computeLetterGrade(mFinalGrade5);
                break;
            case 6:
                letter = computeLetterGrade(mFinalGrade6);
                break;
            case 7:
                letter = computeLetterGrade(mFinalGrade7);
                break;
            case 8:
                letter = computeLetterGrade(mFinalGrade8);
                break;
            default:
                break;
        }
        return letter;
    }

    @Override
    public String toString() {
        return "ReportCard for "+mStudent+
                "\n"+
                "\n"+mSubject1+
                "\nMid-term: "+mMidTermGrade1+
                "\n"+mTeacher1+"'s mid-term comments:"+
                "\n"+mMidTermComments1+
                "\nFinal: "+mFinalGrade1+
                "\n"+mTeacher1+"'s final comments:"+
                "\n"+mFinalComments1+
                "\n"+
                "\n"+mSubject2+
                "\nMid-term: "+mMidTermGrade2+
                "\n"+mTeacher2+"'s mid-term comments:"+
                "\n"+mMidTermComments2+
                "\nFinal: "+mFinalGrade2+
                "\n"+mTeacher2+"'s final comments:"+
                "\n"+mFinalComments2+
                "\n"+
                "\n"+mSubject3+
                "\nMid-term: "+mMidTermGrade3+
                "\n"+mTeacher3+"'s mid-term comments:"+
                "\n"+mMidTermComments3+
                "\nFinal: "+mFinalGrade3+
                "\n"+mTeacher3+"'s final comments:"+
                "\n"+mFinalComments3+
                "\n"+
                "\n"+mSubject4+
                "\nMid-term: "+mMidTermGrade4+
                "\n"+mTeacher4+"'s mid-term comments:"+
                "\n"+mMidTermComments4+
                "\nFinal: "+mFinalGrade4+
                "\n"+mTeacher4+"'s final comments:"+
                "\n"+mFinalComments4+
                "\n"+
                "\n"+mSubject5+
                "\nMid-term: "+mMidTermGrade5+
                "\n"+mTeacher5+"'s mid-term comments:"+
                "\n"+mMidTermComments5+
                "\nFinal: "+mFinalGrade5+
                "\n"+mTeacher5+"'s final comments:"+
                "\n"+mFinalComments5+
                "\n"+
                "\n"+mSubject6+
                "\nMid-term: "+mMidTermGrade6+
                "\n"+mTeacher6+"'s mid-term comments:"+
                "\n"+mMidTermComments6+
                "\nFinal: "+mFinalGrade6+
                "\n"+mTeacher6+"'s final comments:"+
                "\n"+mFinalComments6+
                "\n"+
                "\n"+mSubject7+
                "\nMid-term: "+mMidTermGrade7+
                "\n"+mTeacher7+"'s mid-term comments:"+
                "\n"+mMidTermComments7+
                "\nFinal: "+mFinalGrade7+
                "\n"+mTeacher7+"'s final comments:"+
                "\n"+mFinalComments7+
                "\n"+
                "\n"+mSubject8+
                "\nMid-term: "+mMidTermGrade8+
                "\n"+mTeacher8+"'s mid-term comments:"+
                "\n"+mMidTermComments8+
                "\nFinal: "+mFinalGrade8+
                "\n"+mTeacher8+"'s final comments:"+
                "\n"+mFinalComments8;
    }

    /**
     *
     * @param grade inputted as a int value between 1 - 100 used to determine letter grade.
     * @return returns letter grade as a String.  A,B,C,D,F
     */
    private String computeLetterGrade(int grade) {
        String letter = "";

        if(grade >= A_GRADE){
            letter = "A";
        }else if(grade >= B_GRADE){
            letter = "B";
        }else if(grade >= C_GRADE){
            letter = "C";
        }else if(grade >= D_GRADE){
            letter = "D";
        }else{
            letter = "F";
        }
        return letter;
    }
}