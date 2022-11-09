<template>
  <table>
    <thead>
      <th
        v-for="(item, key) in dataset[0]" :key="key"
      >
        {{ headers[key] }}
      </th>
    </thead>
    <tbody>
      <tr v-for="(datasetItem, datasetKey) in dataset" :key="datasetKey">
        <td
          v-for="(value, name, index) in headers" :key="index"
        >
          {{ formatData(name, datasetItem[name])}}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'Table',
  props: {
    headers: {
      label: Object,
      required: true
    },
    formatters: {
      label: Object,
      required: true
    },
    dataset: {
      label: Array,
      required: true
    }
  },
  methods: {
    formatData (key, data) {
      return typeof this.formatters[key] === 'function' ? this.formatters[key](data) : data
    }
  }
}
</script>

<style>
table {
  width: 100%;
  border-spacing: 0;
  border-radius: 1em;
  overflow: hidden;
}

thead {
 visibility: hidden;
 position: absolute;
 width: 0;
 height: 0;
}

th {
  background: #A5CBF7;
  color: white;
}

td:nth-child(1) {
  background: #A5CBF7;
  color: white;
  border-radius: 1em 1em 0 0;
}

th, td {
  padding: 1em;
}

tr, td {
  display: block;
}

td {
  position: relative;
}

td::before {
  content: attr(data-label);
  position: absolute;
  left: 0;
  padding-left: 1em;
  font-weight: 600;
  font-size: .9em;
  text-transform: uppercase;
}

tr {
  margin-bottom: 1.5em;
  border: 1px solid #A5CBF7;
  border-radius: 1em;
  text-align: right;
}

tr:last-of-type {
  margin-bottom: 0;
}

td:nth-child(n+2):nth-child(odd) {
  background-color: #A5CBF7;
}

@media only screen and (min-width: 768px) {
  table {
    max-width: 1200px;
    margin: 0 auto;
    border: 1px solid #A5CBF7;
  }
  thead {
    visibility: visible;
    position: relative;
  }
  th {
    text-align: left;
    text-transform: uppercase;
    font-size: .9em;
  }
  tr {
    display: table-row;
    border: none;
    border-radius: 0;
    text-align: left;
  }
  tr:nth-child(even) {
  background-color: #A5CBF7;
  }
  td {
    display: table-cell;
  }
  td::before {
    content: none;
  }
  td:nth-child(1) {
    background: transparent;
    color: black;
    border-radius: 0;
  }
  td:nth-child(n+2):nth-child(odd) {
    background-color: transparent;
  }
}
</style>
