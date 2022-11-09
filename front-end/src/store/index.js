import Vue from 'vue'
import Vuex from 'vuex'
import Transfer from './transfer'
import Account from './account'

Vue.use(Vuex)

export default function () {
  const Store = new Vuex.Store({
    modules: {
      Transfer,
      Account
    },

    // enable strict mode (adds overhead!)
    // for dev mode only
    strict: process.env.DEV
  })

  return Store
}
