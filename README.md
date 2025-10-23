# 🧭 Plan – Software Development  
## Project Name: MELI Order Management System Recovery  

**Client:** MELI (Mercado Libre – E-commerce Company)  
**Social Problematic:** MELI faced a severe malfunction in its order management system due to misconfigurations in production satellites and database node failures. These issues caused order processing interruptions, financial losses, and growing customer dissatisfaction. The situation demanded a fast, structured, and scalable backend recovery strategy to restore system reliability and prevent future disruptions.  

**Vision:** The project seeks to rebuild and stabilize MELI’s order management system using Spring Boot 3.0 and Java 17, ensuring robustness, scalability, and efficient environment configuration for production, testing, and development. Through proper database integration, documentation with Swagger, and automated testing, the platform will achieve stability, transparency, and high maintainability.  

**Proposed Solution:** The solution will be executed in three sprints, focusing on structured backend implementation, environment setup, and complete documentation of services. The project will be led by **Arturo Bandini (Software Developer)** under the supervision of **Juan Ventura (Technology Transformation Manager)**.

---

## Swagger evidence
https://github.com/user-attachments/assets/7689be0e-668d-4404-9a81-6316a6b7b365



## 🧩 Team Structure and Responsibilities  

| Team | Role | Responsibilities | Assigned User Stories / Tasks |
|------|------|------------------|-------------------------------|
| 🧠 **Database Manager** | Responsible for database design, schema definition, and environment configuration. Ensures secure and efficient integration between the backend and data layers. | • Create and configure database connections (H2/PostgreSQL).<br>• Define and manage environment profiles (dev, test, prod).<br>• Secure environment variables and sensitive data.<br>• Maintain configuration consistency across all environments. | **User Story 1:** Database and Repo Initialization<br>**User Story 3:** Environment Profiles and Variables |
| ⚙️ **Backend Developer** | Develops core logic, endpoints, and integrations. Implements RESTful architecture, documentation tools, and repository management. | • Implement REST controllers and CRUD operations.<br>• Integrate Swagger and document API endpoints.<br>• Create startup scripts and maintain README updates.<br>• Conduct peer reviews and code optimization. | **User Story 1:** Database and Repo Initialization<br>**User Story 2:** API Testing and Documentation<br>**User Story 4:** Swagger Integration |
| 🧪 **QA Tester** | Ensures code quality, reliability, and performance. Designs and executes test cases for validation and regression testing. | • Develop unit and integration tests with JUnit.<br>• Validate data integrity and API responses.<br>• Perform edge case and stress testing.<br>• Execute final quality verification and documentation. | **User Story 5:** Testing and Quality Validation |

---

## 🧱 Phase 1: Core Resource Development – Sprint 1 (October 14–16)

**Objectives:**
- Initialize a Spring Boot 3.0 web project using Java 17.  
- Implement the Order entity and REST controller with full CRUD operations.  
- Configure and connect the database (H2 for development, PostgreSQL for production).  
- Develop a Postman Collection to test endpoints for order creation, retrieval, update, and deletion.  
- Write a startup script and README.md with setup instructions and repository access details.  
- Add JavaDoc comments to public classes and methods for code clarity.  

**Expected Deliverables:**
- Spring Boot project initialized and hosted on GitHub  
- Functional CRUD operations for Order entity  
- Connected database (H2/PostgreSQL)  
- Postman collection uploaded  
- Startup script and documentation ready  

---

## ⚙️ Phase 2: Environment Configuration and Optimization – Sprint 2 (October 17–19)

**Objectives:**
- Configure environment-specific profiles: development, testing, and production.  
- Define and secure system environment variables to ensure smooth deployment across servers.  
- Implement configuration files (`application-dev.yml`, `application-test.yml`, `application-prod.yml`).  
- Conduct partial peer reviews to detect integration or logic errors early.  
- Document in README.md how to switch between profiles and use system variables effectively.  

**Expected Deliverables:**
- Environment profiles implemented and tested  
- Secure system variable configuration  
- Labeled configuration files per environment  
- Peer review documentation  
- Updated README with configuration guide  

---

## 📘 Phase 3: Documentation and Quality Assurance – Sprint 3 (October 20–21)

**Objectives:**
- Integrate Swagger (OpenAPI) for automatic API documentation and visual testing.  
- Conduct unit and integration tests using JUnit to ensure full functionality of all CRUD operations.  
- Validate both success and failure scenarios to ensure reliability.  
- Finalize Swagger configuration and upload the generated documentation files to the repository.  
- Verify all quality criteria and finalize deliverables for submission.  

**Expected Deliverables:**
- Swagger integrated and configured  
- Unit and integration test suite completed  
- Full API documentation available via Swagger UI  
- Final code repository with test and documentation files  
- Quality checklist met and verified  

---

## 🚀 Benefits of the Solution / Expected Outcomes

- 🛠 **System Reliability:** Stable backend architecture capable of handling large transaction volumes.  
- 🧩 **Scalability:** Modular configuration ready for future services and microservice integration.  
- 🔒 **Security & Maintenance:** Environment-specific variables and configurations ensure secure deployment.  
- 📘 **Transparency:** Comprehensive API documentation through Swagger improves collaboration and debugging.  
- ⚙️ **Efficiency:** Faster issue resolution, better monitoring, and reduced risk of production errors.  
- 💡 **Learning Impact:** Establishes a best-practice reference for backend environment management with Spring Boot.  
