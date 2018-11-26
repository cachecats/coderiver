module.export = {
  devServer: {
    host: 'localhost', // can be overwritten by process.env.HOST
    port: 8088, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-
  }
};