import api from '@/services/api.js'

const state = () => ({
  transfers: {},
  cotation: {}
})

const getters = {
  getTransfers: (state) => {
    return state.transfers
  },
  getCotation: (state) => {
    return state.cotation
  }
}

const mutations = {
  setTransfers (state, payload) {
    state.transfers = payload
  },
  setCotation (state, payload) {
    state.cotation = payload
  }
}

const actions = {
  sendTransfer (context, payload) {
    api
      .post('/agendamento', payload)
      .catch((error) => { console.log(error) })
  },
  getTransfers (context, payload) {
    const setData = (data) => context.commit('setTransfers', data.data)
    api
      .get('/agendamento')
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
