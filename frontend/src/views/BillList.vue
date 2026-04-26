<template>
    <div class="bill-list">
        <h1> 我的记账本</h1>

        <!-- 添加账单列表 -->
        <div class="add-form" >
            <input v-model="form.amount" type="number" placeholder="金额" step="0.01" />
            <select v-model="form.type">
                <option value="0">支出</option>
                <option value="1">收入</option>
            </select>
            <input v-model="form.category" placeholder="分类 （如餐饮）" />
            <input v-model="form.remark" placeholder="备注" />
            <button @click="handleAdd">添加</button>
        </div>

        <!-- 账单列表 -->
        <ul>
            <li v-for="bill in bills" :key="bill.id"> 
                <span class="type">{{ bill.type === '0' ? '支出' : '收入' }}</span>
                <span class="amount">{{ bill.amount }} 元</span>
                <span class="category">{{ bill.category }}</span>
                <span class="remark">{{ bill.remark }}</span>
                <span class="time">{{ bill.createTime }}</span>
                <button @click="handleDelete(bill.id)">删除</button>
            </li>
        </ul>
    </div>
</template> 

<script setup>
import { ref,onMounted } from 'vue'
import { listBills,createBill,deleteBill} from '../api/bill'

const bills = ref([])
const form = ref({
    amount: 0,
    type: 0,
    category: '',
    remark: ''
})

const fetchBills = async () => {
    bills.value = await listBills()    
}

onMounted(fetchBills)

const handleAdd = async () => {
    if (!form.value.amount || !form.value.category) {
        alert('金额和分类不能为空')
        return
    }
    await createBill({
        amount: form.value.amount,
        type: form.value.type,
        category: form.value.category,
        remark: form.value.remark
    })
    form.value = { amount:0, type: 0, category: '', remark: '' }
    fetchBills()
}

const handleDelete = async (id) => {
    if (confirm('确定要删除这一条账单吗？')) {
        await deleteBill(id)
        fetchBills()
    }
}
</script>

<style scoped>
.bill-list {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    font-family: Arial, sans-serif;
}
.add-form {
    display: flex;
    gap:8px;
    flex-wrap: wrap;
    margin-bottom: 30px;
}
.add-form input, .add-form select {
  padding: 6px 10px;
  font-size: 14px;
}
button {
  padding: 6px 12px;
  cursor: pointer;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  border-bottom: 1px solid #ddd;
  padding: 10px 0;
  display: flex;
  align-items: center;
  gap: 10px;
  flex-wrap: wrap;
}
</style>