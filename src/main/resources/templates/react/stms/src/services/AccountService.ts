import axios from "axios";

const ACCOUNT_API_BASE_URL = "http://localhost:8080/api/v1/account"

class AccountService {
    getAccounts() {
        return axios.get(ACCOUNT_API_BASE_URL)
    }

    newAccount(account: any) {
        return axios.post(ACCOUNT_API_BASE_URL, account, {
            headers: {
                "Access-Control-Allow-Origin" : '*',
                'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS'
            },
            responseType: "json"
        })
    }
}

export default new AccountService()