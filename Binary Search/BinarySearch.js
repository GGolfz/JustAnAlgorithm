const binarySearch = (arr, x) => {
    return search(arr, x, 0, arr.length)
}

const search = (arr, x, start, end) => {
    if (start > end) return -1;
  
    let mid=Math.floor((start + end)/2);
    if (arr[mid]===x) return mid;
    if(arr[mid] > x)
        return search(arr, x, start, mid-1);
    else
        return search(arr, x, mid+1, end);
}
