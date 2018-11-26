module.exports = {
  globals: {
    'ts-jest': {
      tsConfigFile: './src/tsconfig.spec.json',
    },
    __TRANSFORM_HTML__: true,
  },
  testMatch: ['**/__tests__/**/*.+(ts|js)?(x)', '**/+(*.)+(spec|test).+(ts|js)?(x)'],
  setupTestFrameworkScriptFile: '<rootDir>/node_modules/@angular-builders/jest/src/jest-config/setup.js',
  transform: {
    '^.+\\.(ts|html)$': '<rootDir>/node_modules/jest-preset-angular/preprocessor.js',
    '\\.(pug)$': '<rootDir>/node_modules/pug-jest'
  },
  transformIgnorePatterns: ['node_modules/(?!@ngrx)'],
  moduleDirectories: [
    "node_modules",
    "src/app",
  ],
  collectCoverageFrom: [
    'src/app/module/**/*.{ts}',
    '!src/app/*.{ts}',
    '!src/app/**/*.{js}',
    '!src/app/environment/*.{ts}',
    '!src/app/language/*.{ts}',
    '!src/app/**/*.module.{ts}',
    '!src/app/**/*.interface.{ts}',
    '!src/app/**/*.state.{ts}',
    '!src/app/**/*.entity.{ts}'
  ],
  moduleFileExtensions: [
    'ts',
    'tsx',
    'json',
    'js'
  ],
  testResultsProcessor: 'jest-sonar-reporter',
  moduleNameMapper: {
    "app/(.*)": "<rootDir>/src/app/$1",
    "@common/(.*)": "<rootDir>/src/app/common/$1",
    "@shared/(.*)": "<rootDir>/src/app/shared/$1",
    "@core/(.*)": "<rootDir>/src/app/core/$1",
    "@services/(.*)": "<rootDir>/src/app/services/$1",
    "@components/(.*)": "<rootDir>/src/app/components/$1",
    "@layout/(.*)": "<rootDir>/src/app/layout/$1",
    "@testing/(.*)": "<rootDir>/src/testing/$1",
    "@env/(.*)": "<rootDir>/src/environments/$1"
  }
};
