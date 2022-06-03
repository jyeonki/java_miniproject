package miniproject.com.kh.hw.member.controller;

import miniproject.com.kh.hw.member.model.vo.Schedule;

public class ScheduleController {

    private Schedule[] scheduleList = new Schedule[TODOSIZE];

    public static final int TODOSIZE = 20;


    // 생성자
    public ScheduleController() {
        scheduleList[0] = new Schedule(1, 2022,6,3,"일정관리 시험", "사장", 2022,6,3);
    }


    // 메서드
    // 현재 등록된 스케줄 수를 반환하는 메서드
    public int existScheduleNum() {
        int count = 0;
        for (int i = 0; i < scheduleList.length; i++) {
            if (scheduleList[i] == null) break;
            count++;
        }
        return count;
    }


    // 스케줄 객체를 반환하는 메서드
    public Schedule[] schedulePrintAll() {
        return scheduleList;
    }


    // 신규 스케줄을 등록하는 메서드
    public void insertSchedule(int idNum, int startYear, int startMonth, int startDay,
                               String toDo, String name, int endYear, int endMonth, int endDay) {

        scheduleList[existScheduleNum()] = new Schedule(idNum, startYear, startMonth, startDay,
                toDo, name, endYear, endMonth, endDay);
    }


    // 일정 고유번호 중복을 확인할 메서드
    public boolean checkIdNum(int idNum) {
        return findIndexByIdNum(idNum) != -1;
    }


    // 등록된 스케줄에서 할 일을 수정하는 메서드 - 고유번호를 입력받아서 해당 번호에 등록된 할 일 수정
    public boolean updateScheduleTodo(int idNum, String toDo) {
        if (findIndexByIdNum(idNum) != -1) {
            scheduleList[findIndexByIdNum(idNum)].setToDo(toDo);
            return true;
        }
        return false;
    }


    // 등록된 스케줄에서 담당자를 수정하는 메서드
    public boolean updateScheduleName(int idNum, String name) {
        if (findIndexByIdNum(idNum) != -1) {
            scheduleList[findIndexByIdNum(idNum)].setName(name);
            return true;
        }
        return false;
    }


    // 등록된 스케줄에서 마감일자를 수정하는 메서드
    public boolean updateScheduleEndDate(int idNum, int endYear, int endMonth, int endDay) {
        if (findIndexByIdNum(idNum) != -1) {
            scheduleList[findIndexByIdNum(idNum)].setEndYear(endYear);
            scheduleList[findIndexByIdNum(idNum)].setEndMonth(endMonth);
            scheduleList[findIndexByIdNum(idNum)].setEndDay(endDay);
            return true;
        }
        return false;
    }


    // 등록된 스케줄을 삭제하는 메서드 - 한개 삭제
    public boolean deleteScheduleOne(int idNum) {
        if (findIndexByIdNum(idNum) != -1) {

            for (int i = findIndexByIdNum(idNum); i < existScheduleNum()-1; i++) {
                scheduleList[i] = scheduleList[i+1];
            }

            scheduleList[existScheduleNum()-1] = null;
            return true;
        }
        return false;
    }


    // 등록된 스케줄 전체 삭제 메서드
    public void deleteScheduleAll() {
        int count = existScheduleNum();

        for (int i = 0; i < count; i++) {
            scheduleList[i] = null;
        }
    }


    // 스케줄 고유 번호를 입력받아 해당 고유번호 스케줄의 인덱스를 찾는 메서드
    public int findIndexByIdNum(int idNum) {
        int index = -1;

        for (int i = 0; i < existScheduleNum(); i++) {
            if (scheduleList[i].getIdNum() == idNum) {
                index = i;
            }
        }
        return index;
    }


} // end class