const path = require('path');
const fs = require('fs');
const webpack = require('webpack');
const nodeExternals = require('webpack-node-externals');
const NodemonPlugin = require('nodemon-webpack-plugin');

const env = process.env.NODE_ENV || 'development';
const dev = env === 'development';

// plugins
const devPlugins = [
  new NodemonPlugin(),
  new webpack.HotModuleReplacementPlugin()
];
const prodPlugins = [];
const commonPlugins = [];
const plugins = dev ? devPlugins.concat(commonPlugins) : prodPlugins.concat(commonPlugins);
const entry = dev ? ['webpack/hot/poll?1000', './src/server/main.ts'] : './src/server/main.ts';
// TODO: add plugins

module.exports = {
  entry,
  output: {
    path: path.resolve(__dirname, "./bin"), 
    filename: "server.bundle.js"
  },
  plugins: plugins,
  target: "node",
  mode: "development",
  externals: [
    nodeExternals({
      whitelist: ['webpack/hot/poll?1000']
    })
  ],
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: ["ts-loader"],
        exclude: /node_modules/
      },
      {
        enforce: "pre",
        test: /\.tsx?$/,
        loader: "tslint-loader",
        options: {
          configFile: "./src/server/tslint.json"
        },
        exclude: /node_modules/,
      }
    ]
  },
  resolve: {
    extensions: [ ".ts", ".tsx", ".js" ]
  }
}
