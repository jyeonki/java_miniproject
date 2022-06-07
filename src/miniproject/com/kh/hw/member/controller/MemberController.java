package miniproject.com.kh.hw.member.controller;

import miniproject.com.kh.hw.member.model.vo.Member;

public class MemberController {

    private Member[] memberList = new Member[SIZE];

    public static final int SIZE = 10;


    // 생성자
    public MemberController() {
        memberList[0] = new Member("hgd220602","홍길동", "부장", "abc@naver.com", "010-1234-5678", 4);
        memberList[1] = new Member("kcs220602", "김철수", "대리", "def@naver.com", "010-4567-1234", 5);
    }


    // 메서드

    // 등록된 직원 수를 확인하는 기능
    public int existMemberNum() {
        int count = 0; // 실제 저장된 직원의 수

        for (Member member : memberList) {
            if (member == null) break;
            count++;
        }
        return count;
    }


    // 아이디 중복을 체크하는 기능
    public boolean checkId(String inputId) {
        return findIndexById(inputId) != -1;
    }


    // 직원 배열을 리턴
    public Member[] printAll() {
        return memberList;
    }


    // 직원정보를 배열 memberList에 저장하는 기능
    public void insertMember(Member newMember) {

        int count = existMemberNum(); // 현재 직원 수
        memberList[count] = newMember; // 추가 할 직원

    }


    // 아이디를 입력하면 해당하는 객체를 return
    public Member searchId(String inputId) {
        int index = findIndexById(inputId);
        return (index != -1) ? memberList[index] : null;
    }


    // 이름을 입력받아 해당하는 객체를 return (동명이인도 포함)
    public Member[] searchName(String name) {

        // 임시 배열 생성
        Member[] temp = new Member[SIZE];
        int count = 0;
        for (int i = 0; i < existMemberNum(); i++) {
            if (name.equals(memberList[i].getName())) {
                temp[count++] = memberList[i];
            }
        }
        // 리턴할 배열
        Member[] returned = new Member[count];
        for (int i = 0; i < returned.length; i++) {
            returned[i] = temp[i];
        }
        return returned;
    }


    // 아이디를 입력받아 직원의 직급을 변경하는 기능
    public boolean updateRank (String id, String newRank) {
        Member member = searchId(id);
        if (member != null) {
            member.setRank(newRank);
            return true;
        }
        return false;
    }

    // 아이디를 입력받아 해당하는 직원의 이메일을 변경하는 기능
    public boolean updateEmail(String id, String newEmail) {
        Member member = searchId(id);
        if (member != null) {
            member.setEmail(newEmail);
            return true;
        }
        return false;
    }

    // 아이디를 입력받아 해당하는 직원의 전화번호를 변경하는 기능
    public boolean updatePhone(String id, String newPhone) {
        Member member = searchId(id);
        if (member != null) {
            member.setPhone(newPhone);
            return true;
        }
        return false;
    }

    // 아이디를 입력받아 해당하는 직원의 가족 수를 변경하는 기능
    public boolean updateFamily(String id, int newFamily) {
        Member member = searchId(id);
        if (member != null) {
            member.setFamily(newFamily);
            return true;
        }
        return false;
    }


    // 아이디를 입력받아 직원 배열에서 특정 직원이 저장된 인덱스를 알려주는 기능
    public int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < existMemberNum(); i++) { // 직원이 있는 만큼만 for문을 돌리겠다
            if (id.equals(memberList[i].getId())) {
                index = i;
                break;
            }
        }
        return index;
    }


    // 직원정보 하나를 삭제하는 메서드
    public boolean delete(String id) {
        int index = findIndexById(id);

        if (index != -1) {
            int count = existMemberNum();
            for (int i = index; i < count - 1; i++) {
                memberList[i] = memberList[i+1];
            }
            // 기존 마지막 직원자리의 주소를 null로 변경
            memberList[count - 1] = null;
            return true;
        }
        return false;
    }

    // 직원정보 전체 삭제
    public void delete() {
        int count = existMemberNum();
        for (int i = 0; i < count; i++) {
            memberList[i] = null;
        }
    }


}//end class