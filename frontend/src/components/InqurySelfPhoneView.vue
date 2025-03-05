<template>

    <v-data-table
        :headers="headers"
        :items="inqurySelfPhone"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'InqurySelfPhoneView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            inqurySelfPhone : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/inqurySelfPhones'))

            temp.data._embedded.inqurySelfPhones.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.inqurySelfPhone = temp.data._embedded.inqurySelfPhones;
        },
        methods: {
        }
    }
</script>

