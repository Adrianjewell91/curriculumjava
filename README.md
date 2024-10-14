Curriculum:

A. Adaptor Pattern. (Med.)
Given a GET endpoint that reads from a database, implement an endpoint that returns the same data but from a new datasource instead.
The new datasource returns data in a different format, but the new endpoint must return data in the same format as the existing endpoint.
Try to reuse as much code and refactor if possible.

B. Domain Decomposition. (Lg.)
Given a monolithic job processor with many jobs, decompose one of the jobs using the available microservices and event streams.
The monolithic job processor runs jobs in batches. It uses direct SQL to load batches and write changes. It uses shared entities (multiple jobs use the same entity). Each job loads more data than is required for the job.
The decomposed job must load data and write changes only through the existing microservices and the existing event streams. It is optional to process data in batches.

C. Abstractions. (Med.)
Given a write flow that accepts data type 1, extend the flow to accept data type 2.
Under the hood, the write flow transforms data type 1 into two objects, data types 1 and 2. The extended flow should result in the same transformation and continue as usual.

D. Consolidation. (Lg.)
Given three applications with three redux stores, combine them into a single redux store.
The three applications exist in the same window under different tabs.

E. Tech Debt.  (Med.)
Given an application with considerable tech debt, upgrade a library using hacky methods that navigates around the tech debt.
The library cannot be “just upgraded” (up the version) because the new version is incompatible with the application framework version. The application framework version cannot be upgraded because there are other libraries that depend on the framework version.
(The solution was the hard code some urls in the application config, which wouldn’t have been necessary if the framework version was upgraded).

F. Interface Preservation. (Med.)
Extend an interface without breaking the existing functionality. The tests that should document the existing functionality are missing.
1. The existing endpoint is a POST endpoint. The new functionality must accept extended configurations of the existing request body and be validated, but the original functionality must not break. It will break if the new validations are applied to the original request payload.

G. Profiling. (Sm.)
Large requests at scale are consuming memory and CPU. Debug the system and remove the high CPU and ram consumption.
1. (The logging of large payloads is the cause of the resource consumption).

H. SQL Optimization. (Sm.)
Optimize a complex SQL query. There are multiple business and technical aspects to the query
1. (The current query does N^2 computations but it can be reduced to N).

I. Canary. (Sm.)
Perform an ingress cutover on a high profile microservice. Deployment a secondary instance with the same ingress, observe the traffic move over to 50/50. Deploy the new version to the original instance. Observe. Delete the secondary instance.

J.  Performance. (Lg.)
A service is showing errors dropped in the service mesh proxy without traces. Investigate the source of the errors, reproduce the error locally and fix it.
1. The proxy is an Istio Service mesh proxy.
2. (the pods are restarting due to the thread exhaustion. High throughput leads to limitless thread creation and no recycling of therads. Limit the thread count. Reproduce locally and set a horizontal scale appropriate to the thread limit.)

K. Open/Closed Principle. (Med.)
Add a side effect, such as an event publishing, to a write endpoint such that existing methods don’t have to be opened.
1. (Instead of MVC use the State Pattern.)
2. (object.load().write(change).publish().publishnewsideeffect())

L. Memory Leak. (Lg.)
Debug a complex system to find the source of the performance.
1. The system has four consumers. Isolate each consumer into four deployments.
2. Use the jvm metrics to observe the offending library and replace it.

K. Legacy Library Upgrade. (Lg.)
Upgrade a base library in a large monolithic repository.
1. Many different strategies will be employed: copying libraries into the code base. Rename some methods, upgrading base frameworks, etc.

M. DRY up Code. (Med.)
Dry up a testing framework that reuses a lot of repeated configuration and code. Some parts of the framework are hard to read (such as request bodies etc).
1. There are complexities such as casting reponse objects in a generic way.

N. Replace Framework. (Med.)
Replace a vanilla graphql implementation with the DGS framework.

O. Scale Horizontally. (Sm.)
Given a simple read endpoint, horizontally scale the endpoint on a container orchestrator so that it meets the SLA for performance.

P. Set Up a Legacy Devbox. (Sm.)
Spin up an instance of the legacy monolith using the legacy devbox set up.
1. Many steps. Spin-up dev box, copy files, run it etc.

Q. API client. (Med.)
Implement an API client into a large repo given a contract. Add unit and integration tests.
1. (Have done this many times, but the exact implementation depends on the api at times).

R. Decoupled Authentication. (Lg.)
Given a decoupled frontend application, add routing and authentication so that the application can interface with the existing ecosystem.
1. There needs to be routing to the application
2. The app needs to access the centralized auth framework
3. The backend services need to recieve session from the frontend and authorize it.

S. Optimization. (Med.)
Given a monolith graphql endpoint, optimize it for large queries.
1. (Involves some conditional logic about what to load and when).

T. Bug Bashing [This could be like 5 projects]. (Lg.)
Given an integration with an api, debug the errors and fix them.
1. (I had at least 5 of these for one api, it had to do with not understanding the idiosyncrasies of the language).
2. Sometimes it was people trying to use database tables in the wrong way.

U. String Variables. (Sm.)
Put all logged strings in a single static util file. The repo will be large and there will be a lot of strings.

V. Docker Image Upgrades (Med.)
A docker image must be upgraded to support new security requirements. Upon upgrading some libraries break, upgrade the libraries.
(Some small amounts of other libraries and code had to be changed to get the build to pass).

W. Mock Processes (Sm.)
A connector exists that publishes kafka messages to bigquery. Mock a producer using the kafka rest proxy to observe messages show up in GBQ.

X. API migration using Ingress. (Med.)
A new service should serve the same ingress endpoint. Implement an adaptor and deploy to the same ingress

Y. Refactor a God Class. (Sm.)
Divide a large controller into several classes without breaking the functionality. There may not be enough tests so cover all the functionality so make sure to check it out.

Z. Decoupling (Med.)
Migrate a subset of sql queries to graphql queries. The mapping should occur at the database level.
(Insert a proxy at the db connection level, ie. sql relay.)

AA. Globals. (Sm.)
Run an application that has an API client with dependencies on global variables. The application will respond with an error message only tangentially pointing to the cause of the error. (http certs)

BB. Code Reuse. (Sm.)
Reuse an implementation from another application. The reusability is such that some small modifications are required, such as method signatures, etc. (retry pattern)

CC. Configurations. (Med.)
Debug and fix an issue in a library that returns the wrong data when in another datacenter. (The data source for the library isn't replicated when it should be replicated).

DD. Tests. (Med.)
Stub all the application dependencies for an integration test. It would include Database, Cache, Secrets, Seed Data.

EE. Configure or Modify. (Sm)
Configure a schema with an annotation instead of modifying downstream code. (Think schema directives).
