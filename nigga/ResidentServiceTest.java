package com.example.test;

import org.springframework.stereotype.Service;

@Service
public class ResidentServiceTest {

        private final ResidentService residentService;
        private final CustomerService customerService;

        public ResidentServiceTest(ResidentService residentService, CustomerService customerService) {
                this.residentService = residentService;
                this.customerService = customerService;
        }

        public String runTests(String useCase) {
                switch (useCase) {
                        case "resident":
                                return runResidentTests();
                        case "administrator":
                                return runAdministratorTests();
                        case "serviceProvider":
                                return runServiceProviderTests();
                        case "customer":
                                return runCustomerServiceTests();
                        default:
                                return "Invalid use case selection.";
                }
        }

        private String runCustomerServiceTests() {
                StringBuilder results = new StringBuilder();
                results.append("Customer Service Test Results:\n");
                results.append("Handle Inquiry Test: ").append(customerService.handleInquiry("Test inquiry"))
                                .append("\n");
                String[] services = customerService.browseServices();
                results.append("Browse Services Test: ").append(services != null && services.length == 3).append("\n");
                results.append("Get Service Details Test: ")
                                .append(customerService.getServiceDetails("Service 1")
                                                .contains("Details for Service 1"))
                                .append("\n");
                results.append("Submit Service Request Test: ")
                                .append(customerService.submitServiceRequest("Service 1"))
                                .append("\n");
                String[] requests = customerService.getMyRequests();
                results.append("Get My Requests Test: ").append(requests != null && requests.length == 3).append("\n");
                results.append("Track Request Status Test: ")
                                .append(customerService.trackRequestStatus("Request 1")
                                                .contains("Status for Request 1"))
                                .append("\n");
                results.append("Provide Feedback Test: ").append(customerService.provideFeedback("Test feedback"))
                                .append("\n");
                results.append("Register for Event Test: ").append(customerService.registerForEvent("Event 1"))
                                .append("\n");
                results.append("Request Document Test: ").append(customerService.requestDocument("Document Type"))
                                .append("\n");
                results.append("Make Payment Test: ").append(customerService.makePayment(100.0)).append("\n");
                results.append("Engage Community Test: ").append(customerService.engageCommunity("Topic", "Message"))
                                .append("\n");
                results.append("Get Service Recommendations Test: ")
                                .append(customerService.getServiceRecommendations() != null)
                                .append("\n");
                return results.toString();
        }

        private String runResidentTests() {
                StringBuilder results = new StringBuilder();
                results.append("Resident Test Results:\n");
                results.append("Login Test: ").append(residentService.login("username", "password")).append("\n");
                String[] services = residentService.browseServices();
                results.append("Browse Services Test: ").append(services != null && services.length == 3).append("\n");
                results.append("Get Service Details Test: ")
                                .append(residentService.getServiceDetails("Service 1")
                                                .contains("Details for Service 1"))
                                .append("\n");
                results.append("Submit Service Request Test: ")
                                .append(residentService.submitServiceRequest("Service 1"))
                                .append("\n");
                String[] requests = residentService.getMyRequests();
                results.append("Get My Requests Test: ").append(requests != null && requests.length == 3).append("\n");
                results.append("Track Request Status Test: ")
                                .append(residentService.trackRequestStatus("Request 1")
                                                .contains("Status for Request 1"))
                                .append("\n");
                results.append("Provide Feedback Test: ").append(residentService.provideFeedback("Test feedback"))
                                .append("\n");
                results.append("Register for Event Test: ").append(residentService.registerForEvent("Event 1"))
                                .append("\n");
                results.append("Request Document Test: ").append(residentService.requestDocument("Document Type"))
                                .append("\n");
                results.append("Make Payment Test: ").append(residentService.makePayment(100.0)).append("\n");
                results.append("Engage Community Test: ").append(residentService.engageCommunity("Topic", "Message"))
                                .append("\n");
                results.append("Get Service Recommendations Test: ")
                                .append(residentService.getServiceRecommendations() != null)
                                .append("\n");
                return results.toString();
        }

        private String runAdministratorTests() {

                AdministratorService adminService = new AdministratorService();

                StringBuilder results = new StringBuilder();
                results.append("Administrator Test Results:\n");

                results.append("Login Test: ").append(adminService.login("admin", "admin123")).append("\n");

                results.append("Create User Test: ").append(adminService.createUser("newUser", "newPass")).append("\n");
                results.append("Update User Test: ").append(adminService.updateUser("existingUser", "updatedPass"))
                                .append("\n");
                results.append("Delete User Test: ").append(adminService.deleteUser("oldUser")).append("\n");
                results.append("Reset User Password Test: ").append(adminService.resetUserPassword("forgotUser"))
                                .append("\n");

                results.append("Assign Role to User Test: ").append(adminService.assignRoleToUser("user1", "Editor"))
                                .append("\n");
                results.append("Revoke Role from User Test: ")
                                .append(adminService.revokeRoleFromUser("user2", "Viewer"))
                                .append("\n");
                results.append("List All Roles Test: ").append(java.util.Arrays.toString(adminService.listAllRoles()))
                                .append("\n");

                results.append("Log Activity Test: ").append(adminService.logActivity("Performed a system backup"))
                                .append("\n");

                results.append("Update System Settings Test: ")
                                .append(adminService.updateSystemSettings("theme", "dark"))
                                .append("\n");
                results.append("View System Settings Test: ").append(adminService.viewSystemSettings("theme"))
                                .append("\n");

                results.append("Generate Audit Report Test: ")
                                .append(java.util.Arrays.toString(adminService.generateAuditReport())).append("\n");

                return results.toString();

        }

        private String runServiceProviderTests() {
                ServiceProviderService serviceProviderService = new ServiceProviderService();

                StringBuilder results = new StringBuilder();
                results.append("Service Provider Test Results:\n");

                String[] serviceRequests = serviceProviderService.getAllServiceRequests();
                results.append("Get All Service Requests Test: ")
                                .append(serviceRequests != null && serviceRequests.length == 3).append("\n");

                boolean respondResult = serviceProviderService.respondToServiceRequest("Req123", "Response message");
                results.append("Respond To Service Request Test: ").append(respondResult).append("\n");

                boolean updateResult = serviceProviderService.updateServiceBasedOnFeedback("ServiceName",
                                "Positive feedback");
                results.append("Update Service Based On Feedback Test: ").append(updateResult).append("\n");

                String[] feedback = serviceProviderService.reviewFeedback();
                results.append("Review Feedback Test: ").append(feedback != null && feedback.length == 3).append("\n");

                boolean scheduleResult = serviceProviderService.scheduleService("ServiceName", "Resident123",
                                "2023-04-20 10:00");
                results.append("Schedule Service Test: ").append(scheduleResult).append("\n");

                boolean cancelResult = serviceProviderService.cancelScheduledService("ServiceName", "Resident123");
                results.append("Cancel Scheduled Service Test: ").append(cancelResult).append("\n");

                boolean logoutResult = serviceProviderService.logout("ServiceProvider1");
                results.append("Logout Test: ").append(logoutResult).append("\n");

                return results.toString();
        }

}