public class CollegeEligibility extends Eligibility {

    @Override
    public boolean checkEligibility(int age, double gpaOrGrade, int incomeChoice, String country) {
        checkCommonCriteria(age, incomeChoice, country);
        gpaCriteria = gpaOrGrade <= 2.5;
        return gpaCriteria && ageCriteria && incomeCriteria && countryCriteria;
    }

    @Override
    public boolean meetsGpaCriteria() {
        return gpaCriteria;
    }

    @Override
    public boolean meetsIncomeCriteria() {
        return incomeCriteria;
    }
}