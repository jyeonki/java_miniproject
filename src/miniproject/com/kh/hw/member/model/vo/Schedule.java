package miniproject.com.kh.hw.member.model.vo;

public class Schedule {

    private int idNum; // 고유번호
    private int startYear; // 등록연도
    private int startMonth; // 등록월
    private int startDay; // 등록일
    private String toDo; // 할 일
    private String name; // 담당자
    private int endYear; // 마감연도
    private int endMonth; // 마감월
    private int endDay; // 마감일


    // 생성자
    public Schedule() {

    }

    public Schedule(int idNum, int startYear, int startMonth, int startDay, String toDo,
                    String name, int endYear, int endMonth, int endDay) {
        this.idNum = idNum;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.toDo = toDo;
        this.name = name;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }


    // 메서드
    public String scheduleInform() {
        return String.format("일정 고유번호: %d || 일정 등록일: %d년 %d월 %d일 || 내용: %s " +
                        "|| 담당자: %s || 마감일: %d년 %d월 %d일",
                idNum, startYear, startMonth, startDay, toDo, name, endYear, endMonth, endDay);
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

} // end class