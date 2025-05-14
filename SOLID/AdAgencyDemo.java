package MongoDB.SOLID;
//q:The new requirements by the marketing team is affecting the business logic of the analytics team. How to tackle this issue provide the improvement on this? Also identify which SOLID principle is violated here and how?
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for Marketing Campaigns
interface MarketingService {
    void createCampaign(String campaignName, String targetAudience);
    void updateCampaign(String campaignName, String newDetails);
}

// Interface for Analytics Data
interface AnalyticsService {
    List<String> getCampaignPerformance(String campaignName);
    void generateReport();
}

// Implementation for Marketing
class MarketingServiceImpl implements MarketingService {
    private List<String> campaigns = new ArrayList<>();

    @Override
    public void createCampaign(String campaignName, String targetAudience) {
        campaigns.add(campaignName + " - Target Audience: " + targetAudience);
        System.out.println("Marketing Campaign Created: " + campaignName);
    }

    @Override
    public void updateCampaign(String campaignName, String newDetails) {
        for (int i = 0; i < campaigns.size(); i++) {
            if (campaigns.get(i).startsWith(campaignName)) {
                campaigns.set(i, campaignName + " - " + newDetails);
                System.out.println("Marketing Campaign Updated: " + campaignName);
                return;
            }
        }
        System.out.println("Campaign not found: " + campaignName);
    }
}

// Implementation for Analytics
class AnalyticsServiceImpl implements AnalyticsService {
    private List<String> campaignData = new ArrayList<>();

    // Assume this data is populated based on campaign performance
    public AnalyticsServiceImpl(List<String> campaignData) {
        this.campaignData = campaignData;
    }

    @Override
    public List<String> getCampaignPerformance(String campaignName) {
        List<String> performanceData = new ArrayList<>();
        for (String data : campaignData) {
            if (data.startsWith(campaignName)) {
                performanceData.add(data);
            }
        }
        return performanceData;
    }

    @Override
    public void generateReport() {
        System.out.println("Generating Analytics Report:");
        for (String data : campaignData) {
            System.out.println(data);
        }
    }
}

public class AdAgencyDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarketingService marketingService = new MarketingServiceImpl();
        // Sample campaign data
        List<String> initialCampaignData = new ArrayList<>();
        initialCampaignData.add("CampaignA - Clicks: 1200, Conversions: 200");
        initialCampaignData.add("CampaignB - Clicks: 850, Conversions: 150");
        AnalyticsService analyticsService = new AnalyticsServiceImpl(initialCampaignData);

        System.out.println("Ad Agency Application");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create Marketing Campaign");
            System.out.println("2. Update Marketing Campaign");
            System.out.println("3. Get Campaign Performance");
            System.out.println("4. Generate Analytics Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter campaign name: ");
                    String campaignName = scanner.nextLine();
                    System.out.print("Enter target audience: ");
                    String targetAudience = scanner.nextLine();
                    marketingService.createCampaign(campaignName, targetAudience);
                    break;
                case 2:
                    System.out.print("Enter campaign name to update: ");
                    String campaignNameToUpdate = scanner.nextLine();
                    System.out.print("Enter new details: ");
                    String newDetails = scanner.nextLine();
                    marketingService.updateCampaign(campaignNameToUpdate, newDetails);
                    break;
                case 3:
                    System.out.print("Enter campaign name to get performance: ");
                    String campaignToGetPerformance = scanner.nextLine();
                    List<String> performance = analyticsService.getCampaignPerformance(campaignToGetPerformance);
                    if (performance.isEmpty()) {
                        System.out.println("No performance data found for campaign: " + campaignToGetPerformance);
                    } else {
                        System.out.println("Performance data for " + campaignToGetPerformance + ":");
                        for (String data : performance) {
                            System.out.println(data);
                        }
                    }
                    break;
                case 4:
                    analyticsService.generateReport();
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

