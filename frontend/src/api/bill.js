import request from '../utils/request'

/**
 * 获取账单列表
 * @returns {Promise} 返回包含账单列表数据的Promise对象
 */
export function listBills() {
  return request.get('/bills')
}

/**
 * 创建账单
 * @param {Object} data - 账单数据对象
 * @param {number} [data.amount] - 账单金额
 * @param {string} [data.type] - 账单类型（收入/支出）
 * @param {string} [data.category] - 账单分类
 * @param {string} [data.date] - 账单日期
 * @param {string} [data.remark] - 备注信息
 * @returns {Promise} 返回创建结果的Promise对象
 */
export function createBill(data) {
  return request.post('/bills', data)
}

/**
 * 更新账单信息
 * @param {string|number} id - 账单ID
 * @param {Object} data - 更新的账单数据
 * @returns {Promise} 返回更新结果的Promise对象
 */
export function updateBill(id, data) {
  return request.put(`/bills/${id}`, data)
}

/**
 * 删除账单
 * @param {string|number} id - 账单ID
 * @returns {Promise} 返回删除操作的Promise对象
 */
export function deleteBill(id) {
  return request.delete(`/bills/${id}`)
}