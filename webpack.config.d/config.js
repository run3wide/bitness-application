config.devServer = {
    open: true,
    static: "../../../../build/processedResources/js/main",
    historyApiFallback: true,
    port: 8081,
};

config.output = {
    path: __dirname + "/build/distributions",
    filename: (chunkData) => {
        return chunkData.chunk.name === 'main'
            ? "bitness.js"
            : "bitness.js";
    },
    library: "bitness",
    libraryTarget: "umd",
    globalObject: "this",
    publicPath: "/"
};

config.resolve.alias = {
    "crypto": false,
}