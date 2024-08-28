# Soil Detection Web Application

## Overview

The Soil Detection Web Application is designed to analyze soil properties to determine ideal conditions for planting trees, focusing on sustainable land use in Africa. This application uses Spring Boot for the backend and React for the frontend. It incorporates Flyway for database migrations and uses PostgreSQL as the database.

## Project Structure

- **Backend (Spring Boot)**
    - Located in the `backend` directory.
- **Frontend (React)**
    - Located in the `frontend` directory.
- **Docker**
    - Docker Compose file for setting up PostgreSQL and other services is located in the root directory.

## Prerequisites

- Java 21 or later
- Node.js (for the React frontend)
- Docker and Docker Compose
- PostgreSQL
- Flyway CLI

## Setup Instructions

### Docker Setup

1. **Build and Start Docker Containers:**
   Ensure Docker and Docker Compose are installed. Run the following command from the root directory to build and start the containers:
   ```bash
   docker-compose up --build
