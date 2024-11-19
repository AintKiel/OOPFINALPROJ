public abstract class Eligibility implements EligibilityCriteria {
    protected boolean gpaCriteria;
    protected boolean ageCriteria;
    protected boolean incomeCriteria;
    protected boolean countryCriteria;

    @Override
    public boolean meetsCountryCriteria() {
        return countryCriteria;
    }

    @Override
    public boolean meetsAgeCriteria() {
        return ageCriteria;
    }

    @Override
    public abstract boolean checkEligibility(int age, double gpaOrGrade, int incomeChoice, String country);

    protected void checkCommonCriteria(int age, int incomeChoice, String country) {
        ageCriteria = age >= 16 && age <= 24;
        incomeCriteria = incomeChoice <= 3;
        countryCriteria = "Philippines".equalsIgnoreCase(country.trim());
    }
}