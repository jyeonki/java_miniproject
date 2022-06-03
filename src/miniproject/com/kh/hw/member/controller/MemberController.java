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
    /**
     * 실제로 배열에 저장되어 있는 직원객체의 숫자를 세는 메서드
     *
     * @return count - 실제 저장된 직원의 수
     */
    public int existMemberNum() {
        int count = 0; // 실제 저장된 직원의 수

        for (Member member : memberList) {
            if (member == null) break;
            count++;
        }
        return count;
    }

    /**
     * 아이디 중복을 체크하는 메서드
     *
     * @param inputId - 중복을 확인할 사용자의 입력 아이디
     * @return 중복되었으면 true, 아니면 false
     */
    public boolean checkId(String inputId) {
        return findIndexById(inputId) != -1;
    }


    //직원 배열 리턴
    public Member[] printAll() {
        return memberList;
    }

    //직원정보를 배열 m에 저장하는 메서드
    public void insertMember(Member newMember) {

        int count = existMemberNum(); // 현재 직원 수
        memberList[count] = newMember; // 추가 할 직원

    }








    /**
     * 아이디를 입력하면 해당 직원 객체를 리턴
     *
     * @param inputId - 검색할 직원의 사원아이디
     * @return Member - 찾은 경우 해당 아이디를 가진 직원의 전체정보를 가진 객체
     * - 못 찾은 경우 null 리턴
     */
    public Member searchId(String inputId) {
        int index = findIndexById(inputId);
        return (index != -1) ? memberList[index] : null;
    }


    /**
     *
     * @param name - 검색할 직원의 이름
     * @return 동명이인 포함 해당 이름과 일치하는 모든 직원정보 배열
     */
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


    /**
     * 직원의 직급을 변경하는 메소드
     *
     * @param id      - 직급이 변경될 직원의 아이디
     * @param newRank - 새로운 직급
     * @return - 변경 성공 여부
     */
    public boolean updateRank (String id, String newRank) {
        Member member = searchId(id);
        if (member != null) {
            member.setRank(newRank);
            return true;
        }
        return false;
    }



    /**
     * @param id       - 수정할 직원의 아이디
     * @param newEmail - 수정될 이메일
     * @return 수정 성공시 true
     */
    public boolean updateEmail(String id, String newEmail) {
        Member member = searchId(id);
        if (member != null) {
            member.setEmail(newEmail);
            return true;
        }
        return false;
    }

    /**
     * @param id      - 수정할 직원의 아이디
     * @param newPhone - 수정될 전화번호
     * @return 수정 성공시 true
     */
    public boolean updatePhone(String id, String newPhone) {
        Member member = searchId(id);
        if (member != null) {
            member.setPhone(newPhone);
            return true;
        }
        return false;
    }

    /**
     * @param id      - 수정할 직원의 아이디
     * @param newFamily - 수정될 가족 수
     * @return 수정 성공시 true
     */
    public boolean updateFamily(String id, int newFamily) {
        Member member = searchId(id);
        if (member != null) {
            member.setFamily(newFamily);
            return true;
        }
        return false;
    }



    /**
     * 아이디를 통해 직원 배열에서 특정 직원이 저장된 인덱스를 알려주는 기능
     *
     * @param id - 찾을 직원의 아이디값
     * @return 찾은 직원의 인덱스값, 못찾을 시 -1 리턴
     */
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


    //직원정보 하나를 삭제하는 메서드

    /**
     * @param id - 퇴사한 직원의 아이디정보
     * @return 삭제성공시 true, 직원이 존재하지 않아 실패시 false
     */
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



}