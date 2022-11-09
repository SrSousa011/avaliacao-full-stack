<template>
  <div class="home">
    <Card class="card">
      <Input
        class="row-custom"
        label="Insira o número da sua conta"
        mask="######"
        v-model="model.contaOrigem"
        :isInvalid="validations.contaOrigem"
        validationMessage="Conta de origem inválida"
      />
      <Input
        class="row-custom"
        label="Número da conta do destinatário"
        type="text"
        mask="######"
        v-model="model.contaDestino"
        :isInvalid="validations.contaDestino"
        validationMessage="Conta destino inválida"
      />
      <Money
        class="row-custom"
        label="Valor"
        v-model="model.valorOperacao"
        :isInvalid="validations.valorOperacao"
        validationMessage="Valor inválido"
      />
      <Input
        class="row-custom"
        label="Data da transferêcia"
        type="Date"
        v-model="model.dataTransferencia"
        :isInvalid="validations.dataTransferencia"
        validationMessage="Data inválida"
      />
      <Button class="row-custom" label="Confirma" @click="sendTransfer"/>
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
        contaOrigem: '',
        contaDestino: '',
        valorOperacao: '',
        dataTransferencia: ''
      },
      validations: {
        contaOrigem: false,
        contaDestino: false,
        valorOperacao: false,
        dataTransferencia: false
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
    async sendTransfer () {
      if (this.validate(this.model)) {
        return
      }
      await this.$store.dispatch('Transfer/sendTransfer', this.model)
      this.model = {
        contaOrigem: '',
        contaDestino: '',
        valorOperacao: '',
        dataTransferencia: ''
      }
    },
    async getCotation () {
      await this.$store.dispatch('Transfer/getCotation', this.model)
      this.cotation = this.$store.getters['Transfer/getCotation']
    },
    validate (model) {
      const validations = this.validations
      validations.valorOperacao = parseFloat(model.valorOperacao) <= 0
      validations.contaOrigem = model.contaOrigem.length < 6
      validations.contaDestino = model.contaDestino.length < 6
      validations.dataTransferencia = model.dataTransferencia.length <= 0
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
