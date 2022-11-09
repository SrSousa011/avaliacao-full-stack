<template>
  <div class="home">
    <Card class="card">
      <Input
        class="row-custom"
        label="Insira o número da sua conta"
        mask="######"
        v-model="model.numero"
        :isInvalid="validations.numero"
        validationMessage="Conta de origem inválida"
      />
      <Money
        class="row-custom"
        label="Saldo"
        v-model="model.saldo"
        :isInvalid="validations.saldo"
        validationMessage="Valor inválido"
      />
      <Button class="row-custom" label="Criar Conta" @click="sendAccount"/>
    </Card>
  </div>
</template>

<script>
import Input from '@/components/Input.vue'
import Card from '@/components/Card.vue'
import Button from '@/components/Button.vue'
import Money from '@/components/Money.vue'

export default {
  name: 'Home',
  data: () => {
    return {
      model: {
        numero: '',
        saldo: ''
      },
      validations: {
        numero: false,
        saldo: false
      }
    }
  },
  components: {
    Input,
    Card,
    Button,
    Money
  },
  methods: {
    async sendAccount () {
      if (this.validate(this.model)) {
        return
      }
      await this.$store.dispatch('Account/sendAccount', this.model)
      this.model = {
        numero: '',
        saldo: ''
      }
    },
    async getCotation () {
      await this.$store.dispatch('Transfer/getCotation', this.model)
      this.cotation = this.$store.getters['Transfer/getCotation']
    },
    validate (model) {
      const validations = this.validations
      validations.saldo = parseFloat(model.saldo) <= 0
      validations.numero = model.numero.length < 6
      return !!Object.keys(validations).find((key) => { return validations[key] === true })
    }
  }
}
</script>

<style scoped>
.h2 {
  color: red;
}
.card {
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: flex-start;
    align-content: stretch;
    align-items: center;
    width: 300px;
}
.row-custom {
  margin: 15px;
  width: 250px;
}
.row {
  margin: 10px;
}

</style>
