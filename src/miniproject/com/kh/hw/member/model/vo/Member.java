package miniproject.com.kh.hw.member.model.vo;

public class Member {

    private String id; // 사원아이디
    private String name; // 이름
    private String rank; // 직급
    private String email; // 이메일
    private String phone; // 전화번호
    private int basePay; // 기본 급여
    private int family; // 가족 수
//        private Bonus[] bonus;

    private int familyBonus; // 가족 수당 인당 10만원
    private int familyBonusRate = 100000;

    private double taxRate; // 세율

    private int monthSalary; // 한 달 세후 월급


    //생성자
    public Member(String id, String name, String rank, String email, String phone, int family) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.family = family;

        initBasePay(rank);
        initFamilyBonus(family);
        initTaxRate();      // 기본급, 가족보너스 산출 후 실행되어야함.
        initMonthSalary();   // 기본급, 가족보너스, 세율 산출 후 실행되어야함.
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getFamilyBonus() {
        return familyBonus;
    }

    public void setFamilyBonus(int familyBonus) {
        this.familyBonus = familyBonus;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    // 메서드
    public String informBasic() {
        return String.format("[사원 아이디: %s || 이름 : %s || 직급 : %s || 이메일 : %s || 전화번호 : %s || 가족 수 : %d ]",
                id, name, rank, email, phone, family);
    }

    public String informSalary() {
        return String.format("[사원 아이디: %s || 이름 : %s || 직급 : %s || 기본급 : %d || 가족수당 : %d || 세율 : %.2f || 세후 급여 : %d ]",
                id, name, rank, basePay, familyBonus, taxRate, monthSalary);
    }

    public String informTotal() {
        return String.format("[사원 아이디: %s || 이름 : %s || 직급 : %s || 이메일 : %s || 전화번호 : %s ||" +
                        " 가족 수 : %d || 기본급 : %d || 가족수당 : %d || 세율 : %.2f || 세후 급여 : %d]",
                id, name, rank, email, phone, family, basePay, familyBonus, taxRate, monthSalary);
    }

    private void initBasePay(String rank) {

        switch (rank) {
            case "사원" :
                setBasePay(2000000);
                break;
            case "대리" :
                setBasePay(2500000);
                break;
            case "과장" :
                setBasePay(3000000);
                break;
            case "부장" :
                setBasePay(3500000);
                break;
        }
    }

    private void initFamilyBonus(int family) {

        setFamilyBonus(family * this.familyBonusRate);
    }

    private void initTaxRate() {

        int sum = this.basePay + this.familyBonus;

        if (sum >= 2000000 && sum < 2500000) {
            setTaxRate(0.05);
        } else if (sum >= 2500000 && sum < 3000000) {
            setTaxRate(0.1);
        } else if (sum >= 3000000 && sum < 3500000) {
            setTaxRate(0.15);
        } else if (sum >= 3500000) {
            setTaxRate(0.2);
        }
    }

    private void initMonthSalary() {

        setMonthSalary((int) (basePay + familyBonus - ((basePay + familyBonus) * taxRate)));
    }

} // end class