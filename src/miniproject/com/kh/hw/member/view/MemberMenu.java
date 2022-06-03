package miniproject.com.kh.hw.member.view;

import miniproject.com.kh.hw.member.controller.MemberController;
import miniproject.com.kh.hw.member.model.vo.Member;

import java.util.Scanner;

public class MemberMenu {

    Scanner sc = new Scanner(System.in);

    private MemberController mc = new MemberController();


    // 메서드
    public void mainMenu() {
        while (true) {
            System.out.println("======================== 직원 월급 관리 프로그램 ========================");
            System.out.println("# 1. 직원 등록");
            System.out.println("# 2. 직원 정보 조회");
            System.out.println("# 3. 직원 정보 수정");
            System.out.println("# 4. 직원 삭제");
            System.out.println("# 9. 끝내기");
            System.out.print("메뉴 번호: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    // 1. 신규 직원 등록
                    insertMember();
                    break;
                case 2:
                    // 2. 직원 정보 조회
                    searchMember();
                    break;
                case 3:
                    // 3. 직원 정보 수정
//                    updateMember();
                    break;
                case 4:
                    // 4. 직원 삭제
//                    deleteMember();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // 프로세스 종료
                    break;
                default:
                    System.out.println("잘못된 메뉴를 입력하였습니다.");
            }
        } // end while

    } // end mainMenu

    // method

    // 1번 메뉴 처리 메서드
    // 신규 직원 등록
    private void insertMember() {

        System.out.println("\n # 신규 직원을 등록합니다.");

        String id = null;
        while (true) {
            id = inputStr("- 직원 아이디: ");
            if (!mc.checkId(id)) break; // 아이디 중복 체크
            System.out.println("- 중복된 직원 아이디입니다!");
        }

        String name = inputStr("- 이름: ");
        String rank = inputStr("- 직급 [사원, 대리, 과장, 부장]: ");
        String email = inputStr("- 이메일: ");
        String phone = inputStr("- 전화번호: ");
        int family = inputNumber("- 가족 수: ");


        Member member = new Member(id, name, rank, email, phone, family);

        mc.insertMember(member);

        System.out.println("\n# 직원 등록이 완료되었습니다.");

    }


    // 2번 메뉴 처리 메서드
    // 직원 정보 조회
    // [전직원 정보 조회, 개인별 정보 조회]
    private void searchMember() {

        System.out.println("======================== 직원 정보 조회 ========================");

        System.out.println("# 1. 전직원 정보 조회하기");
        System.out.println("# 2. 개인별 정보 조회하기");
        System.out.println("# 9. 정보 조회 메뉴 나가기");

        int menu = inputNumber("- 메뉴 입력: ");
        switch (menu) {
            case 1:
                // 전직원 정보 조회
                checkAllMember();
                break;
            case 2:
                // 개인별 정보 조회
//                checkMember();
                break;
            case 9:
                return;
            default:
                System.out.println("메뉴를 잘못 입력하셨습니다.");
        }
    }

    // 메뉴 2-1번 처리 메서드
    public void checkAllMember() {
//        informTotal();
    }


//    private void searchMember() {
//
//        System.out.println("======================== 직원 정보 조회 ========================");
//
//        System.out.println("# 1. 아이디로 조회하기");
//        System.out.println("# 2. 이름으로 조회하기");
//        System.out.println("# 9. 정보 조회 메뉴 나가기");
//
//        int menu = inputNumber("- 메뉴 입력: ");
//        switch (menu) {
//            case 1:
//                // 아이디 조회
//                searchId();
//                break;
//            case 2:
//                // 이름 조회
//                searchName();
//                break;
//            case 9:
//                return;
//            default:
//                System.out.println("메뉴를 잘못 입력하셨습니다.");
//        }
//    }


    // 메뉴 2-1번 처리 메서드
    private void searchId() {

        String targetId = inputStr("- 조회할 아이디: ");
        Member member = mc.searchId(targetId);

        if (member != null) {
            searchInformation(member);
        } else {
            System.out.println("\n- 존재하는 회원이 아닙니다.");
        }
    }

    // 메뉴 2-2번 처리 메서드
    private void searchName() {
        String targetName = inputStr("- 조회할 이름: ");
        Member[] members = mc.searchName(targetName);
        if (members.length > 0) {

            System.out.println("\n=========== 검색된 회원 정보 ============");
            for (Member member : members) {

                searchInformation(member);
            }
        } else {
            System.out.println("\n- 존재하는 회원이 아닙니다.");
        }
    }

    private void searchInformation(Member targetMember) {

        System.out.println("======================== 직원 정보 조회 ========================");

        System.out.println("# 1. 직원 개인정보 조회");
        System.out.println("# 2. 직원 급여 조회");
        System.out.println("# 3. 모든 정보 조회");
        System.out.println("# 9. 정보 조회 메뉴 나가기");

        int menu = inputNumber("- 메뉴 입력: ");
        switch (menu) {
            case 1:
                // 직원 개인정보 조회
                System.out.println(targetMember.informBasic());
                break;
            case 2:
                // 직원 급여 조회
                System.out.println(targetMember.informSalary());
                break;
            case 3:
                // 모든 정보 조회
                System.out.println(targetMember.informTotal());
                break;
            case 9:
                return;
            default:
                System.out.println("메뉴를 잘못 입력하셨습니다.");
        }
        //        System.out.println(m.inform());
    }








    // 입력처리를 간단하게 만드는 메서드
    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }
    private int inputNumber(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }

} // end class
