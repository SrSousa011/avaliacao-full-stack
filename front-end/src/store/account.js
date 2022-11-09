import api from '@/services/api.js'

const state = () => ({
  account: {},
  cotation: {}
})

const getters = {
  getAccount: (state) => {
    return state.account
  },
  getCotation: (state) => {
    return state.cotation
  }
}

const mutations = {
  setAccount (state, payload) {
    state.account = payload
  },
  setCotation (state, payload) {
    state.cotation = payload
  }
}

const actions = {
  sendAccount (context, payload) {
    api
      .post('/conta', payload)
      .catch((error) => { console.log(error) })
  },
  getAccount (context, payload) {
    const setData = (data) => context.commit('setAccount', data.data)
    api
      .get('/conta')
      .then(setData)
      .catch((error) => { console.log(error) })
  }
}

export default {
  namespaced: true,
  getters,
  mutations,
  actions,
  state
}
