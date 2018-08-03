new Vue({
    el: '#loginForm',
    data: {
        loginForm: {
            // 202141420
            account: '202141420',
            password: '202141420'
        }
    },
    methods: {
        login() {
            axios.defaults.withCredentials = true;
            axios.post(oaURL.api.hasUser(), objectToForm({
                    account: this.loginForm.account,
                    password: this.loginForm.password
                }))
                .then(function(res) {
                    console.log(res.data);
                    switch (res.data.flag) {
                        case 1:
                            console.log('登录成功！');
                            location.href = 'home.html';
                            localStorage.setItem('token', res.data.token);
                            break;
                        case 0:
                            console.log('账号或者密码错误！');
                            break;
                        default:
                            console.log('服务器开了小差，请等一等。');
                            break;
                    }
                })
                .catch(function(err) {
                    console.error(err);
                });
        }
    }
});