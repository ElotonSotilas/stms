import axios from "axios";

const ACCOUNT_API_BASE_URL = "http://localhost:8080/api/v1/account"

class AccountService {
    getAccounts() {
        return axios.get(ACCOUNT_API_BASE_URL)
    }

    getAccountById(accountId: any) {
        return axios.get(ACCOUNT_API_BASE_URL + '/' + accountId)
    }

    newAccount(account: any) {
        return axios.post(ACCOUNT_API_BASE_URL, account)
    }

    modifyAccount(accountId: any, accountData: any) {
        return axios.put(ACCOUNT_API_BASE_URL + '/' + accountId, accountData)
    }

    dropAccount(accountId: any) {
        return axios.delete(ACCOUNT_API_BASE_URL + "/" + accountId)
    }
}

export default new AccountService()