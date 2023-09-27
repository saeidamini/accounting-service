# Accounting Microservice

The Accounting microservice handles financial and accounting functions like invoicing, payments, and reconciliation.

## Overview

Managing finances is a key part of any business. This service provides accounting capabilities for the overall application in a decentralized manner.

It implements functions like:

- Invoice generation
- Payment processing 
- Tax calculation
- Financial reporting
- Reconciliation 

And more!

## Roadmap

Here is a rough 8 week roadmap to build out core capabilities:

### Week 1

- Generate skeleton Spring Boot scaffolding
- Implement basic invoice generation
- Add unit tests

### Week 2

- Build payment processing workflow
- Integrate payment gateway APIs
- Logging and monitoring

### Week 3

- Calculate taxes on invoices
- Generate invoices on order completion

### Week 4 

- Reporting dashboard
- Invoice reconciliation 

*Mid-point Review*

- Basic invoicing and payments working

### Week 5

- Role based access control
- Audit logs
- Exception handling

### Week 6

- Scheduled reconciliation jobs
- Reminders and notifications

### Week 7

- Connect to accounting system via APIs
- Financial data integration

### Week 8

- Performance testing
- Security review
- Documentation

## Getting Started

Eager to dig in? Start by cloning the repo and installing dependencies:

```
git clone https://github.com/saeidamini/accounting-service.git
cd accounting-service
mvn install
```

Let the number crunching begin!

## Local environment

- [Local server](http://localhost:8080)

<!-- jhipster-needle-localEnvironment -->

## Start up

```bash
./mvnw
```

<!-- jhipster-needle-startupCommand -->

## Documentation

- [Package types](documentation/package-types.md)
- [Assertions](documentation/assertions.md)
- [Logs spy](documentation/logs-spy.md)
- [CORS configuration](documentation/cors-configuration.md)
- [Cucumber](documentation/cucumber.md)

<!-- jhipster-needle-documentation -->

## Contributions

We welcome contributions! Please feel free to fix bugs, build new features, or improve documentation.

Happy accounting! 👨‍💻
