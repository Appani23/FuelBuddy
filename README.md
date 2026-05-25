<div align="center">

# ⛽ FuelBuddy

### Find the cheapest gas near you — instantly.

[![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![React Native](https://img.shields.io/badge/React_Native-Mobile-61DAFB?style=for-the-badge&logo=react&logoColor=black)](https://reactnative.dev/)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![AWS](https://img.shields.io/badge/AWS-Cloud-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)](https://aws.amazon.com/)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Phase_1_%7C_MVP-orange?style=for-the-badge)]()

</div>

---

## 📖 About FuelBuddy

**FuelBuddy** is a cross-platform mobile application for iOS and Android that helps drivers find the **cheapest gas stations** in their area in real time. Using the device's GPS, FuelBuddy surfaces nearby stations ranked by fuel price, empowering users to save money on every fill-up.

Users can fine-tune results by adjusting the search radius and filtering by fuel grade — making FuelBuddy useful whether you drive a compact car, a diesel truck, or a performance vehicle.

---

## ✨ Features

| Feature | Description |
|---|---|
| 📍 **Location-Based Search** | Automatically detects your current GPS position to find nearby stations |
| 💰 **Price Ranking** | Lists gas stations sorted from cheapest to most expensive |
| 🔄 **Adjustable Search Radius** | Choose from **2, 5, 10, or 25 miles** to match your willingness to drive |
| ⛽ **Fuel Type Filters** | Filter by **Regular, Mid-Grade, Premium, or Diesel** |
| 🗺️ **Interactive Map View** | Visualize station locations on a live map |
| 🔔 **Price Alerts** *(planned)* | Get notified when prices drop below your target |
| 🔐 **Secure Authentication** | JWT-based login with Spring Security |
| ⚡ **Real-Time Updates** | Price updates streamed via Apache Kafka |

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| **Java 17** | Core backend language |
| **Spring Boot** | Microservices framework |
| **Spring Security + JWT** | Authentication & authorization |
| **Hibernate / JPA** | ORM and database access |
| **MySQL 8** | Relational database |
| **Apache Kafka** | Event streaming for real-time price updates |

### Infrastructure & DevOps
| Technology | Purpose |
|---|---|
| **Docker** | Containerization |
| **Kubernetes** | Container orchestration |
| **AWS** | Cloud hosting (EC2, RDS, S3, EKS) |
| **GitHub Actions** | CI/CD pipelines |

### Mobile
| Technology | Purpose |
|---|---|
| **React Native** | Cross-platform iOS & Android app |

### Testing
| Technology | Purpose |
|---|---|
| **JUnit 5** | Unit testing |
| **Mockito** | Mocking framework |

---

## 🏗️ Project Structure

```
FuelBuddy/
├── backend/                        # Spring Boot microservices
│   ├── api-gateway/                # Entry point, routing & auth
│   ├── user-service/               # User registration, login, JWT
│   ├── station-service/            # Gas station data & pricing
│   ├── location-service/           # Geospatial search & radius logic
│   ├── notification-service/       # Price alerts (Kafka consumer)
│   └── common/                     # Shared DTOs, utilities
│
├── mobile-app/                     # React Native application
│   ├── src/
│   │   ├── screens/                # Map, Search, Auth screens
│   │   ├── components/             # Reusable UI components
│   │   ├── services/               # API clients
│   │   └── store/                  # State management
│   └── __tests__/
│
├── docs/                           # Architecture diagrams & API specs
├── .github/
│   └── workflows/                  # GitHub Actions CI/CD pipelines
├── docker-compose.yml              # Local development stack
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+**
- **Node.js 18+** and **npm / yarn**
- **Docker & Docker Compose**
- **MySQL 8+**
- **React Native CLI** (or Expo)

### 1. Clone the Repository

```bash
git clone https://github.com/appanivignesh/FuelBuddy.git
cd FuelBuddy
```

### 2. Start the Backend (Docker Compose)

```bash
# Spin up MySQL, Kafka, Zookeeper, and all microservices
docker-compose up --build
```

The API Gateway will be available at `http://localhost:8080`.

### 3. Configure Environment Variables

Copy the example env file and fill in your values:

```bash
cp .env.example .env
```

| Variable | Description |
|---|---|
| `DB_URL` | MySQL connection URL |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |
| `JWT_SECRET` | Secret key for signing JWT tokens |
| `KAFKA_BOOTSTRAP_SERVERS` | Kafka broker address |
| `AWS_ACCESS_KEY_ID` | AWS credentials (for S3/deployment) |
| `AWS_SECRET_ACCESS_KEY` | AWS credentials |

### 4. Run the Mobile App

```bash
cd mobile-app
npm install

# iOS
npx react-native run-ios

# Android
npx react-native run-android
```

### 5. Run Tests

```bash
# Backend unit & integration tests
cd backend
./mvnw test

# Mobile tests
cd mobile-app
npm test
```

---

## 📊 Current Status

> **Phase 1 — MVP Development** 🚧

| Milestone | Status |
|---|---|
| Project scaffolding & repo setup | ✅ Complete |
| Microservices architecture design | ✅ Complete |
| User authentication (JWT) | 🔄 In Progress |
| Station data ingestion (Kafka) | 🔄 In Progress |
| Geospatial search by radius | 🔄 In Progress |
| React Native app shell | 🔄 In Progress |
| Docker Compose local dev stack | ⏳ Planned |
| CI/CD with GitHub Actions | ⏳ Planned |
| AWS deployment (EKS) | ⏳ Planned |
| Phase 2 — Price Alerts & Social Features | ⏳ Backlog |

---

## 🗺️ Roadmap

- **Phase 1 (MVP):** Location-based station search, fuel type filtering, price ranking, user auth
- **Phase 2:** Price drop alerts, user-submitted price reports, favorites list
- **Phase 3:** Community reviews, route-based search (find cheap gas along your drive), premium features

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to open an issue or submit a pull request.

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 👤 Author

**Vignesh Appani**

- GitHub: [@appanivignesh](https://github.com/appanivignesh)
- Email: appanivignesh23@gmail.com

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

<div align="center">
  <sub>Built with ❤️ by Vignesh Appani</sub>
</div>
