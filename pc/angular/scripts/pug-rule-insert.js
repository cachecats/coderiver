const fs = require('fs');
const commonCliConfig = 'node_modules/@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs/common.js';
const pug_rule = `\n\t\t\t\t\t\t\t\t{ test: /.(pug|jade)$/, loader: 'apply-loader!pug-loader?self' },`;

fs.readFile(commonCliConfig, (err, data) => {
  if (err) { throw err; }

  const configText = data.toString();
  if (configText.indexOf(pug_rule) > -1) { return; }

  const position = configText.indexOf('rules: [') + 8;
  const output = [configText.slice(0, position), pug_rule, configText.slice(position)].join('');
  let file = fs.openSync(commonCliConfig, 'r+');
  fs.writeFile(file, output, () => {});
  fs.close(file, () => {});
});
