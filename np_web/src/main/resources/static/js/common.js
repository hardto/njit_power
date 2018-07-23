const oaURL = {
    protocol: '//',
    hostname: '101.132.138.141',
    port: 8888,
    getBaseURL() {
        return `${this.protocol}${this.hostname}:${this.port}/`
    },
    api: {
        hasUser() {
            return `${oaURL.getBaseURL()}hasUser`;
        },
        updateUser() {
            return `${oaURL.getBaseURL()}service/updateUser`;
        },
        sendMail() {
            return `${oaURL.getBaseURL()}sendMail`;
        },
        validMailCode() {
            return `${oaURL.getBaseURL()}validMailCode`;
        },
        pageUsers() {
            return `${oaURL.getBaseURL()}service/pageUsers`;
        },
        searchSchInfo() {
            return `${oaURL.getBaseURL()}service/searchSchInfo`;
        }
    }
};

function objectToForm(o) {
    let params = new URLSearchParams();
    for (let k in o) {
        if (o.hasOwnProperty(k))
            params.append(k, o[k]);
    }
    return params;
}