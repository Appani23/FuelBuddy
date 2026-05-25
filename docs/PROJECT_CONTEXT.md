# 📘 FuelBuddy — Complete Project Context Document

*Save this document for future reference. If the chat ever breaks, paste this whole thing into a new Claude conversation to resume work seamlessly.*

---

## 👤 Developer Info

- **Name:** Vignesh Appani (Vikky)
- **Role:** Java Developer at NYS ITS (Department of Tax and Finance)
- **Experience:** ~6 years (Java, Spring Boot, Microservices)
- **Education:** MS in Computer Science, University at Albany
- **Certifications:** AWS Developer Associate, AWS Cloud Practitioner
- **Location:** Albany, NY
- **GitHub:** github.com/Appani23

---

## 💻 Development Environment

- **Machine:** MacBook Pro M4 (Apple Silicon, ARM64)
- **macOS Version:** 26.3.1 (Tahoe)
- **Test Device:** iPhone (for real device testing)
- **AI Assistant:** Claude Code (Claude Pro subscription)
- **Project Location:** `~/Desktop/FuelBuddy`

---

## 🎯 Project: FuelBuddy

### Concept
A location-based mobile app (iOS + Android) that helps users find the **cheapest gas stations nearby**, sorted by lowest fuel price within a user-selected radius (2/5/10/25 miles).

### Core User Flow
1. User opens app → app requests location permission (like Uber/DoorDash)
2. User grants permission → app shows current GPS location
3. App displays nearby gas stations sorted by **lowest fuel price first**
4. User can adjust radius via slider (2, 5, 10, 25 miles)
5. User can filter by fuel type (Regular, Mid, Premium, Diesel)
6. User taps a station → sees details → taps "Get Directions" → opens Maps

### Project Goal
1. Build a **real, end-to-end mobile app** showcasing full-stack Java developer skills
2. Practical exposure to industry-standard tech stack
3. Showcase on resume for job applications
4. Eventually publish to App Store + Play Store

---

## 🛠️ Final Tech Stack (Locked)

| Layer | Technology |
|---|---|
| Mobile Frontend | React Native (iOS + Android) |
| Backend | Java 17, Spring Boot, Microservices |
| ORM | Hibernate / JPA |
| Messaging | Apache Kafka (Phase 2) |
| Database | MySQL only |
| Caching | Redis (Phase 2) |
| Cloud | AWS (EKS, S3, Lambda, API Gateway, RDS) — Phase 4 |
| Containers | Docker + Kubernetes (Phase 4) |
| CI/CD | GitHub + GitHub Actions |
| Authentication | Spring Security + JWT (Phase 1), Okta + OAuth2 (Phase 2) |
| Testing | JUnit + Mockito |
| API Docs | Postman + Swagger |
| Monitoring | AWS CloudWatch (Phase 4) |
| Project Management | Jira |
| External APIs | Google Maps, Firebase FCM (Phase 2), Fuel Price API (Phase 2) |

### Explicitly removed from plan:
- ❌ PostgreSQL (using MySQL only)
- ❌ MongoDB (not needed)
- ❌ Admin web dashboard (mobile-only app)
- ❌ GitLab (using GitHub)
- ❌ Terraform (manual AWS setup)
- ❌ Splunk, Prometheus, Grafana (CloudWatch only)
- ❌ Expo (using bare React Native + Xcode since user has Mac + iPhone)

---

## 🏗️ Backend Architecture (Microservices)

### Phase 1 services:
1. **User Service** — signup, login, JWT, profile
2. **Station Service** — nearby search by lat/long + radius
3. **Price Service** — current fuel prices + history

### Phase 2 services (later):
4. **Notification Service** — Kafka-driven push alerts
5. **Favorites Service** — saved stations

---

## 🗃️ Database Schema (MySQL)

### Tables:
- `users` — id, email, password_hash, name, created_at
- `stations` — id, name, brand, address, latitude, longitude, phone, hours
- `fuel_prices` — id, station_id, fuel_type, price, updated_at
- `price_history` — id, station_id, fuel_type, price, recorded_at
- `favorites` (Phase 2) — id, user_id, station_id
- `alerts` (Phase 2) — id, user_id, station_id, target_price, is_active
- `community_reports` (Phase 2) — id, user_id, station_id, fuel_type, reported_price, verified_count

---

## 📅 Project Phases

### Phase 1 — MVP (Weeks 1-4) ← *currently here*
Auth + nearby stations + radius + filter + directions. Local development only.

### Phase 2 — Enhanced Features (Weeks 10-13)
Favorites, price alerts, Kafka, push notifications, Redis cache, real Fuel Price API integration, OAuth2 social login (Google/Apple), price history charts, community price reporting.

### Phase 3 — Advanced (Weeks 14-16)
Trip planner, ML price prediction, amenities filter, brand preference.

### Phase 4 — Production (Week 17+)
AWS deployment, Docker/Kubernetes, CloudWatch, Terraform (optional), App Store + Play Store launch.

---

## 📅 Phase 1 Week-by-Week Plan

| Week | Goal |
|---|---|
| **Week 1** | Tool setup + Backend foundation (User Service: signup, login, JWT) |
| **Week 2** | Station Service + Price Service + sample data |
| **Week 3** | React Native project setup + login/signup screens |
| **Week 4** | Nearby stations UI + Google Maps integration + iPhone testing |

---

## ✅ Day 1 Progress (Completed)

| # | Tool | Status |
|---|---|---|
| 1 | Homebrew (v5.1.13) | ✅ Installed |
| 2 | Git (v2.39.5) | ✅ Already had |
| 3 | Node.js (v22.13.0) | ✅ Already had |
| 4 | Java JDK 17 (17.0.19) | ✅ Installed |
| 5 | Maven (3.9.16, using JDK 17) | ✅ Installed |
| 6 | VS Code (1.110.1) | ✅ Installed + `code` command enabled |
| 7 | Claude Code (2.1.150) | ✅ Installed + authenticated (Claude Pro, Sonnet 4.6) |

**Project folder created:** `~/Desktop/FuelBuddy`

---

## ⏳ Day 2 In Progress

- 🟡 Xcode (downloading from App Store — 10-15 GB)
- 🟡 Docker Desktop (.dmg downloaded, about to install)
- ⏭️ Postman (next)
- ⏭️ MySQL Workbench (next)
- ⏭️ Watchman + CocoaPods (next)
- ⏭️ IntelliJ IDEA Community (optional, later)

---

## 🎯 Current Step

**Installing Docker Desktop** — `.dmg` is downloaded, user is about to:
1. Drag Docker.app to Applications folder
2. Open Docker
3. Complete first-time setup
4. Verify whale icon in top menu bar

---

## 📋 Communication Preferences

- **Pace:** Slow, step-by-step, one command at a time
- **Style:** Explain what each command does and WHY
- **Verification:** Confirm each step works before moving to next
- **No rushing:** Don't dump multiple commands at once
- **Tone:** Friendly, casual, supportive (uses "Vikky" as nickname)
- **Education:** First-time mobile app developer — needs basics explained clearly

---

## 🔑 Key Decisions Made

- Building **mobile app only** (no admin web dashboard)
- Using **Spring Security + JWT** initially (Okta deferred to Phase 2)
- Using **MySQL only** as primary DB
- Using **bare React Native** (not Expo) since user has Mac + iPhone
- Using **GitHub Actions** for CI/CD (not GitLab)
- Skipping **Terraform** initially (manual AWS setup)
- Skipping **Splunk/Prometheus/Grafana** (CloudWatch only)

---

## 🚀 Resume Command (If Chat Breaks)

If our chat ever gets stuck, paste this entire document into a new Claude conversation along with:

> "Hi Claude, this is Vignesh (Vikky). I'm building FuelBuddy with you. Here's our project context document. Please review it and let's continue from where we left off. We were last working on [paste current step here]."

This way, the new Claude instance will have full context and we can pick up smoothly.

---

## 📝 Notes / Updates Log

*Keep this section updated as we make progress. Add new entries below.*

- **Day 1 (May 23, 2026):** Installed Homebrew, Java 17, Maven, VS Code, Claude Code. Created project folder.
- **Day 2 (May 24, 2026):** Started Xcode download. Installing Docker Desktop, then Postman, MySQL Workbench, Watchman, CocoaPods.

---

*End of context document. Last updated: May 24, 2026.*
