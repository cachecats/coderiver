const ngxWallabyJest = require('ngx-wallaby-jest');

module.exports = function (wallaby) {
  return {
    files: [
      'src/**/*.+(ts|html|json|snap|css|less|sass|scss|jpg|jpeg|gif|png|svg)',
      'tsconfig.json',
      'tsconfig.spec.json',
      'jest.config.js',
      '!src/**/*.spec.ts',
    ],

    tests: ['src/**/*.spec.ts'],

    env: {
      type: 'node',
      runner: 'node'
    },
    compilers: {
      '**/*.ts?(x)': wallaby.compilers.typeScript({ module: 'commonjs' }),
    },
    preprocessors: {
      // This translate templateUrl and styleUrls to the right implementation
      // For wallaby
      'projects/**/*.component.ts': ngxWallabyJest,
    },
    testFramework: 'jest'
  };
};
