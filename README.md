# purchaseexercise
Just a simple exercise on microservices for purchases

Example service calls:
http://localhost:8080/PurchaseMicroservice/Purchase?service=getValidPurchases
http://localhost:8080/PurchaseMicroservice/Purchase?service=createOrUpdatePurchase&id=1&productType=Nice&expires=1475277636110&purchaseDetails=2,coisas,4,5;6,ping,4,5
http://localhost:8080/PurchaseMicroservice/Purchase?service=createOrUpdatePurchaseDetail&
http://localhost:8080/PurchaseMicroservice/Purchase?service=getPurchaseById&id=2
http://localhost:8080/PurchaseMicroservice/Purchase?service=getPurchaseById&id=1
http://localhost:8080/PurchaseMicroservice/Purchase?service=getPurchaseDetailCount
http://localhost:8080/PurchaseMicroservice/Purchase?service=getPurchaseCount
http://localhost:8080/PurchaseMicroservice/Purchase?service=metrics

TO scale the service, several instances can be run in same container, same VM or in multiple containers or VMs, behind a load balancer for example.
SLA can be monitored via the available metrics service.