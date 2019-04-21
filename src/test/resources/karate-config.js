function fn() {
  karate.configure('connectTimeout', 15000);
  karate.configure('readTimeout', 15000);
  var occiautoApiBaseUrl = karate.properties['services.occiuato.baseUrl'];
  var castlemockApiBaseUrl = karate.properties['castlemock.baseUrl'];
  var castlemockUsername = karate.properties['castlemock.username'];
  var castlemockPassword = karate.properties['castlemock.password'];
  var castlemockMareiguaPath = karate.properties['castlemock.workInformation.mareigua.path'];
  var castlemockSoiPath = karate.properties['castlemock.workInformation.soi.path'];
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  karate.log('Occiauto API base URL:', occiautoApiBaseUrl);
  karate.log('Castlemock base URL:', castlemockApiBaseUrl);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
	myVarName: 'someValue',
    occiautoApiBaseUrl: occiautoApiBaseUrl,
    castlemockApiBaseUrl: castlemockApiBaseUrl,
    castlemockUsername:castlemockUsername,
    castlemockPassword:castlemockPassword,
    castlemockMareiguaPath:castlemockMareiguaPath,
    castlemockSoiPath:castlemockSoiPath
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}