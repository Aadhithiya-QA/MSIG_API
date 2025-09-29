package DataProviderUtil;

import java.util.HashMap;
import java.util.Map;

public class ExcelJsonMapper {

    // Excel column → JSON placeholder mapping
    private static final Map<String, String> excelToJsonMapping = Map.ofEntries(
            // Main sheet
            Map.entry("PolicyEffectiveDate", "PolicyEffectiveDate"),
            Map.entry("PolicyExpirationDate", "PolicyExpirationDate"),
            Map.entry("States", "States"),

            // Policy-level
            Map.entry("StateRegionCode","StateRegionCode"),
            Map.entry("Subline","Subline"),
            Map.entry("GovernmentalSubdivision","GovernmentalSubdivision"),
            Map.entry("ProdsWithdrawalCoverage", "ProdsWithdrawalCoverage"),
            Map.entry("PremOpsProdsEachOccurrenceLimit", "PremOpsProdsEachOccurrenceLimit"),
            Map.entry("MedicalPaymentsExcl", "MedicalPaymentsExcl"),
            Map.entry("PersonalandAdvertisingInjuryLimit", "PersonalandAdvertisingInjuryLimit"),
            Map.entry("GeneralAggregateLimit", "GeneralAggregateLimit"),
            Map.entry("ProdsCompldOpsAggregateLimit", "ProdsCompldOpsAggregateLimit"),
            Map.entry("PremOpsBIDeductible", "PremOpsBIDeductible"),
            Map.entry("ProdsCompldOpsBIDeductible","ProdsCompldOpsBIDeductible"),
            Map.entry("PremOpsPDDeductible", "PremOpsPDDeductible"),
            Map.entry("ProdsCompldOpsPDDeductible","ProdsCompldOpsPDDeductible"),
            Map.entry("PremOpsBIPDDeductible", "PremOpsBIPDDeductible"),
            Map.entry("ProdsCompldOpsBIPDDeductible","ProdsCompldOpsBIPDDeductible"),
            Map.entry("PremOpsProdsCoverageForm","PremOpsProdsCoverageForm"),
            Map.entry("YearInClaimsMade", "YearInClaimsMade"),
            Map.entry("RetroactiveDateApplies", "RetroactiveDateApplies"),
            Map.entry("PremOpsProdsRetroactiveDate", "PremOpsProdsRetroactiveDate"),
            Map.entry("ProductsWithdrawalCutOff", "ProductsWithdrawalCutOff"),
            Map.entry("ProductWithdrawalParticipationPercentage", "ProductWithdrawalParticipationPercentage"),
            Map.entry("LegalEntity", "LegalEntity"),
            Map.entry("LimitedCovForDesignatedUnmannedAircraft", "LimitedCovForDesignatedUnmannedAircraft"),
            Map.entry("ExperienceRatingApplies", "ExperienceRatingApplies"),
            Map.entry("ScheduleRatingModificationApplies","ScheduleRatingModificationApplies"),
            Map.entry("TRIPTerminatesBeforeExpirationDate", "TRIPTerminatesBeforeExpirationDate"),
            Map.entry("TerrorismCoverage", "TerrorismCoverage"),

            // Location-level
            Map.entry("LocationNumber", "LocationNumber"),
            Map.entry("Address","Address"),
            Map.entry("PremOpsBIDeductibleLocation","PremOpsBIDeductibleLocation"),
            Map.entry("PremOpsPDDeductibleLocation","PremOpsPDDeductibleLocation"),
            Map.entry("PremOpsBIPDDeductibleLocation","PremOpsBIPDDeductibleLocation"),
            Map.entry("ProdsCompldOpsBIDeductibleLocation","ProdsCompldOpsBIDeductibleLocation"),
            Map.entry("ProdsCompldOpsPDDeductibleLocation","ProdsCompldOpsPDDeductibleLocation"),
            Map.entry("ProdsCompldOpsBIPDDeductibleLocation","ProdsCompldOpsBIPDDeductibleLocation"),
            Map.entry("PremisesOperationsTerr", "PremisesOperationsTerr"),
            Map.entry("PremisesOperationsTerritory", "PremisesOperationsTerritory"),
            Map.entry("ProdsCompldOpsTerritory", "ProdsCompldOpsTerritory"),

            // Classification-level
            Map.entry("ProductCoverage", "ProductCoverage"),
            Map.entry("ClassCode", "ClassCode"),
            Map.entry("ClassDescription", "ClassDescription"),
            Map.entry("Classification Type", "ClassificationType"),
            Map.entry("PremOpsBIDeductibleClass", "PremOpsBIDeductibleClass"),
            Map.entry("PremOpsPDDeductibleClass", "PremOpsPDDeductibleClass"),
            Map.entry("PremOpsBIPDDeductibleClass", "PremOpsBIDeductibleClass"),
            Map.entry("PremOpsPremiumBasis", "PremOpsPremiumBasis"),
            Map.entry("IfAnyBasis", "IfAnyBasis"),
            Map.entry("PremOpsCovExposure", "PremOpsCovExposure"),
            Map.entry("ProdsCompldOpsBIDeductibleClass", "ProdsCompldOpsBIDeductibleClass"),
            Map.entry("ProdsCompldOpsPDDeductibleClass", "ProdsCompldOpsPDDeductibleClass"),
            Map.entry("ProdsCompldOpsBIPDDeductibleClass", "ProdsCompldOpsBIDeductibleClass"),
            Map.entry("ProdsCompldOpsPremiumBasis","ProdsCompldOpsPremiumBasis"),
            Map.entry("IfAnyBasisProdsCompldOps", "IfAnyBasisProdsCompldOps"),
            Map.entry("ProdsCompldOpsCovExposure", "ProdsCompldOpsCovExposure")
    );

    public static Map<String, String> remapParams(Map<String, String> mergedParams) {
        Map<String, String> mappedParams = new HashMap<>();
        for (Map.Entry<String, String> e : mergedParams.entrySet()) {
            String excelKey = e.getKey();
            String value = normalizeValue(e.getValue()); // ✅ normalize first

            if (excelToJsonMapping.containsKey(excelKey)) {
                mappedParams.put(excelToJsonMapping.get(excelKey), value);
            } else {
                mappedParams.put(excelKey, value); // fallback
            }
        }
        return mappedParams;
    }

    // ✅ Handles Yes/No, trims, blanks
    private static String normalizeValue(String raw) {
        if (raw == null) return "";
        String v = raw.trim();

        if (v.equalsIgnoreCase("yes")) return "Yes";
        if (v.equalsIgnoreCase("no")) return "No";

        return v; // keep as-is for numbers/strings
    }
}
