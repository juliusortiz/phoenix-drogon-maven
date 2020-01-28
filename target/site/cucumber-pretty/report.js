$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginAdmin.feature");
formatter.feature({
  "line": 2,
  "name": "Login Admin",
  "description": "This feature deals with the admin page accessibility and navigations",
  "id": "login-admin",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SmokeTest"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Login admin user and navigate to all pages",
  "description": "",
  "id": "login-admin;login-admin-user-and-navigate-to-all-pages",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "logged in as admin user",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "navigate to status page from the dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "navigate to customer page from the dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "navigate to truck driver page from the dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "navigate to Manage Users page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Logout",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginAdmin1.loggedInAsAdminUser()"
});
formatter.result({
  "duration": 14608661000,
  "status": "passed"
});
formatter.match({
  "location": "LoginAdmin1.navigateToStatusPageFromTheDashboard()"
});
formatter.result({
  "duration": 4452348900,
  "status": "passed"
});
formatter.match({
  "location": "LoginAdmin1.navigateToCustomerPageFromTheDashboard()"
});
formatter.result({
  "duration": 2057590600,
  "status": "passed"
});
formatter.match({
  "location": "LoginAdmin1.navigateToTruckDriverPageFromTheDashboard()"
});
formatter.result({
  "duration": 2171976200,
  "status": "passed"
});
formatter.match({
  "location": "LoginAdmin1.navigateToManageUsersPage()"
});
formatter.result({
  "duration": 1112554000,
  "error_message": "org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element \u003cbutton class\u003d\"navbar__sidebar-toggle\"\u003e...\u003c/button\u003e is not clickable at point (32, 42). Other element would receive the click: \u003cdiv class\u003d\"popup display-block\"\u003e...\u003c/div\u003e\n  (Session info: chrome\u003d79.0.3945.130)\nBuild info: version: \u00274.0.0-alpha-4\u0027, revision: \u0027c2d955b49e\u0027\nSystem info: host: \u0027LAPTOP-OSLLQ5OA\u0027, ip: \u0027192.168.72.162\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 79.0.3945.130, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\DICE205\\AppData\\Lo...}, goog:chromeOptions: {debuggerAddress: localhost:64598}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: be50e75cc512eb1c336218977b7ef56f\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:196)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:129)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:161)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:582)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:316)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:85)\r\n\tat StepClasses.LoginAdmin1.navigateToManageUsersPage(LoginAdmin1.java:99)\r\n\tat ✽.And navigate to Manage Users page(LoginAdmin.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginAdmin1.logout()"
});
formatter.result({
  "status": "skipped"
});
});